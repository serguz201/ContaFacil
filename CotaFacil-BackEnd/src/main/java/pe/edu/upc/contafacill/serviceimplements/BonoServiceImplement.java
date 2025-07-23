package pe.edu.upc.contafacill.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.contafacill.entities.Bono;
import pe.edu.upc.contafacill.entities.CatalogoMoneda;
import pe.edu.upc.contafacill.entities.FlujoCaja;
import pe.edu.upc.contafacill.entities.ResultadosFinancieros;
import pe.edu.upc.contafacill.repositories.IBonoRepository;
import pe.edu.upc.contafacill.repositories.IFlujoCajaRepository;
import pe.edu.upc.contafacill.repositories.IResultadosFinancierosRepository;
import pe.edu.upc.contafacill.serviceinterfaces.IBonoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class BonoServiceImplement implements IBonoService {

    @Autowired private IBonoRepository bonoRepository;
    @Autowired private IFlujoCajaRepository flujoCajaRepository;
    @Autowired private IResultadosFinancierosRepository resultadosFinancierosRepository;

    @Override public List<Bono> list() { return bonoRepository.findAll(); }

    @Override public void insert(Bono bono) {
        bonoRepository.save(bono);
        DatosIntermedios d = calcularDatosIntermedios(bono);
        generarYGuardarFlujoCaja(bono, d);
        generarYGuardarResultadosFinancieros(bono, d);
    }

    @Override public void update(Bono bono) {
        bonoRepository.save(bono);
        flujoCajaRepository.deleteByIdBono(bono.getIdBono());
        resultadosFinancierosRepository.deleteByIdBono(bono.getIdBono());
        DatosIntermedios d = calcularDatosIntermedios(bono);
        generarYGuardarFlujoCaja(bono, d);
        generarYGuardarResultadosFinancieros(bono, d);
    }

    @Override public void delete(int bonoId) { bonoRepository.deleteById(bonoId); }

    @Override public Bono listId(int id) { return bonoRepository.findById(id).orElse(new Bono()); }

    @Override public List<Bono> findByUserId(int idUser) { return bonoRepository.findByUserId(idUser); }



    private double obtenerTipoCambio(Bono bono) {
        CatalogoMoneda m = bono.getIdCatalogoMoneda();
        return (m == null || m.getTipoCambio() <= 0) ? 1.0 : m.getTipoCambio();
    }

    private static class DatosIntermedios {
        double valorNominalLocal;
        int    frecuenciaCupon;
        int    diasCapitalizacion;
        int    numPeriodosPorAno;
        int    numTotalPeriodos;
        double tasaEfectivaAnual;
        double tasaEfectivaPeriodo;
        double cok;
        double costesInicialesEmisor;
        double costesInicialesBonista;
        double inflacionPorPeriodo;
        double valorComercial;
    }

    private DatosIntermedios calcularDatosIntermedios(Bono b) {
        double fx = obtenerTipoCambio(b);
        DatosIntermedios d = new DatosIntermedios();

        /* Tiempo y tasas */
        d.frecuenciaCupon    = obtenerDiasFrecuenciaPago(b);
        d.diasCapitalizacion = obtenerDiasCapitalizacion(b);
        d.numPeriodosPorAno  = b.getDiasPorAno() / d.frecuenciaCupon;
        d.numTotalPeriodos   = b.getNumeroAños() * d.numPeriodosPorAno;

        d.tasaEfectivaAnual  = calcularTasaEfectivaAnual(b, d.diasCapitalizacion);
        d.tasaEfectivaPeriodo= Math.pow(1 + d.tasaEfectivaAnual,
                (double) d.frecuenciaCupon / b.getDiasPorAno()) - 1;
        d.cok                = Math.pow(1 + b.getTasaAnualDescuento(),
                (double) d.frecuenciaCupon / b.getDiasPorAno()) - 1;

        /* Valores monetarios en moneda local */
        d.valorNominalLocal  = b.getValorNominal() * fx;
        d.valorComercial     = d.valorNominalLocal * (1 +
                b.getCostesInicialesBonista() + b.getCostesInicialesOtros() + b.getPrima());
        d.costesInicialesEmisor  = d.valorComercial *
                (b.getCostesInicialesBonista() + b.getCostesInicialesOtros());
        d.costesInicialesBonista = d.valorComercial * b.getCostesInicialesBonista();

        /* Inflación por período */
        d.inflacionPorPeriodo= Math.pow(1 + b.getInflacion(),
                (double) d.frecuenciaCupon / b.getDiasPorAno()) - 1;
        return d;
    }

    public int obtenerDiasFrecuenciaPago(Bono b) {
        if (b == null || b.getFrecuenciaCupon() == null) return 0;
        switch (b.getFrecuenciaCupon().trim().toLowerCase()) {
            case "mensual":       return 30;
            case "bimestral":     return 60;
            case "trimestral":    return 90;
            case "cuatrimestral": return 120;
            case "semestral":     return 180;
            case "anual":         return 360;
            default:               return 0;
        }
    }

    public int obtenerDiasCapitalizacion(Bono b) {
        if (b == null || b.getCapitalizacion() == null) return 0;
        switch (b.getCapitalizacion().trim().toLowerCase()) {
            case "diaria":        return 1;
            case "quincenal":     return 15;
            case "mensual":       return 30;
            case "bimestral":     return 60;
            case "trimestral":    return 90;
            case "cuatrimestral": return 120;
            case "semestral":     return 180;
            case "anual":         return 360;
            default:               return 0;
        }
    }

    private double calcularTasaEfectivaAnual(Bono b, int dCap) {
        if ("efectiva".equalsIgnoreCase(b.getTipoTasa())) return b.getTasaInteres();
        double n = (double) b.getDiasPorAno() / dCap;
        return Math.pow(1 + (b.getTasaInteres() / n), n) - 1;
    }

    /* ======================= Generación de flujos ====================== */
    private void generarYGuardarFlujoCaja(Bono bono, DatosIntermedios d) {
        List<FlujoCaja> flujos = new ArrayList<>();
        LocalDate fecha = bono.getFechaEmision();
        double saldo    = d.valorNominalLocal;

        /* -------- Período 0: desembolso -------- */
        FlujoCaja f0 = new FlujoCaja();
        f0.setPeriodo(0);
        f0.setFechaProgramada(fecha);
        f0.setPlazoGracia("S");
        f0.setBono(0);
        f0.setBonoIndexado(0);
        f0.setCuponInteres(0);
        f0.setCuota(0);
        f0.setAmortizacion(0);
        f0.setPrima(0);
        f0.setEscudo(0);
        f0.setFlujoEmisor(d.valorComercial - d.costesInicialesEmisor);
        f0.setFlujoEmisorEscudo(f0.getFlujoEmisor());
        f0.setFlujoBonista(-d.valorComercial - d.costesInicialesBonista);
        f0.setFlujoAct(0);
        f0.setFaPlazo(0);
        f0.setConvexidad(0);
        f0.setBonos(bono);
        flujos.add(f0);

        /* -------- Parámetros de gracia -------- */
        int    nGracia = bono.getPlazoPeridos() == null ? 0 : bono.getPlazoPeridos();
        String tGracia = bono.getPlazoTipo() == null ? "SIN" : bono.getPlazoTipo().trim().toUpperCase();
        boolean esGraciaValida = nGracia > 0 && (tGracia.equals("TOTAL") || tGracia.equals("PARCIAL"));

        double cuotaFrancesa = 0; // se calcula al salir de gracia

        /* -------- Periodos 1 … N -------- */
        for (int k = 1; k <= d.numTotalPeriodos; k++) {
            FlujoCaja fc = new FlujoCaja();
            fc.setPeriodo(k);
            fecha = fecha.plusDays(d.frecuenciaCupon);
            fc.setFechaProgramada(fecha);

            /* Saldo y actualización por inflación */
            fc.setBono(saldo);
            double bonoIndexado = saldo * (1 + d.inflacionPorPeriodo);
            fc.setBonoIndexado(bonoIndexado);

            double interes = bonoIndexado * d.tasaEfectivaPeriodo;

            boolean enGracia   = k <= nGracia && esGraciaValida;
            boolean esTotal    = enGracia && tGracia.equals("TOTAL");
            boolean esParcial  = enGracia && tGracia.equals("PARCIAL");

            double cuota; double amortizacion; double cuponInteres; double prima = 0;

            if (esTotal) {
                /* Gracia total: no se paga nada */
                cuota = amortizacion = cuponInteres = 0;
                fc.setPlazoGracia("T");
            } else if (esParcial) {
                /* Gracia parcial: solo intereses */
                cuota           = interes;
                cuponInteres    = -interes;
                amortizacion    = 0;
                fc.setPlazoGracia("P");
            } else {
                /* Periodo normal (fuera de gracia) */
                if (cuotaFrancesa == 0) {
                    int periodosRestantes = d.numTotalPeriodos - k + 1;
                    cuotaFrancesa = calcularCuotaFrancesa(saldo, d.tasaEfectivaPeriodo, periodosRestantes);
                }
                cuota           = cuotaFrancesa;
                cuponInteres    = -interes;
                amortizacion    = cuota - interes;
                if (k == d.numTotalPeriodos) {
                    amortizacion = saldo;
                    cuota        = interes + amortizacion;
                }
                fc.setPlazoGracia("S");
            }

            /* Asignamos valores */
            fc.setCuota(cuota);
            fc.setCuponInteres(cuponInteres);
            fc.setAmortizacion(amortizacion);

            /* Prima solo al final */
            if (k == d.numTotalPeriodos) {
                prima = bono.getPrima() * bonoIndexado;
            }
            fc.setPrima(prima);

            /* Escudo fiscal */
            double escudo = cuponInteres == 0 ? 0 : (-cuponInteres) * bono.getImpuesto();
            fc.setEscudo(escudo);

            /* Flujos del emisor y del bonista */
            fc.setFlujoEmisor(prima + cuota);
            fc.setFlujoEmisorEscudo(fc.getFlujoEmisor() + escudo);
            fc.setFlujoBonista(-cuota - prima);

            /* Valor presente y métricas */
            double flujoAct = fc.getFlujoBonista() / Math.pow(1 + d.cok, k);
            fc.setFlujoAct(flujoAct);
            double deltaAnios = (double) d.frecuenciaCupon / bono.getDiasPorAno();
            fc.setFaPlazo(flujoAct * k * deltaAnios);
            fc.setConvexidad(flujoAct * k * (k + 1));

            fc.setBonos(bono);
            flujos.add(fc);

            /*        Actualizar saldo para el siguiente periodo        */
            if (esTotal) {
                saldo = bonoIndexado + interes; // se capitaliza
            } else {
                saldo = bonoIndexado - amortizacion; // amortización (o 0 en gracia parcial)
            }
        }

        flujoCajaRepository.saveAll(flujos);
    }

    private double calcularCuotaFrancesa(double principal, double tasa, int n) {
        if (n <= 0) return 0;
        double factor = Math.pow(1 + tasa, n);
        return principal * tasa * factor / (factor - 1);
    }

    /* ================= Impresión de resultados financieros ============= */
    private void generarYGuardarResultadosFinancieros(Bono bono, DatosIntermedios d) {
        List<FlujoCaja> flujos = flujoCajaRepository.list_bono_id(bono.getIdBono());

        double totalFlujoAct = flujos.stream().mapToDouble(FlujoCaja::getFlujoAct).sum();
        double duracion      = flujos.stream().mapToDouble(FlujoCaja::getFaPlazo).sum() / totalFlujoAct;
        double sumConv       = flujos.stream().mapToDouble(FlujoCaja::getConvexidad).sum();

        double delta         = (double) d.frecuenciaCupon / bono.getDiasPorAno();
        double convexidad    = (sumConv * delta * delta) / (totalFlujoAct * (1 + d.cok));
        double duracionMod   = duracion / (1 + d.cok);
        double precioActual  = -totalFlujoAct;
        double utilidad      = precioActual - d.valorNominalLocal;

        double tceaEmisor    = flujos.stream().mapToDouble(FlujoCaja::getFlujoEmisor).sum() / d.valorNominalLocal / 100.0;
        double tceaEmisorEsc = flujos.stream().mapToDouble(FlujoCaja::getFlujoEmisorEscudo).sum() / d.valorNominalLocal / 100.0;
        double treaBonista   = -flujos.stream().mapToDouble(FlujoCaja::getFlujoBonista).sum() / d.valorNominalLocal / 100.0;

        ResultadosFinancieros r = new ResultadosFinancieros();
        r.setBonos(bono);
        r.setPrecioActual(precioActual);
        r.setUtilidad(utilidad);
        r.setDuracion(duracion);
        r.setConvexidad(convexidad);
        r.setDuracionModificada(duracionMod);
        r.setTotal(precioActual);
        r.setPrecioMaxMercado(precioActual);
        r.setTceaEmisor(tceaEmisor);
        r.setTceaEmisorEscudo(tceaEmisorEsc);
        r.setTreaBonista(treaBonista);

        resultadosFinancierosRepository.save(r);
    }
}
