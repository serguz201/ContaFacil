package pe.edu.upc.contafacill.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "FlujoCaja")
public class FlujoCaja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdFlujoCaja;

    @Column(name = "Periodo", nullable = false)
    private int Periodo;

    @Column(name = "Fecha_Programada", nullable = false)
    private LocalDate FechaProgramada;

    @Column(name = "Plazo_Gracia", length = 30)
    private String PlazoGracia;

    @Column(name = "Bono")
    private double Bono;

    @Column(name = "Bono_Indexado")
    private double BonoIndexado;

    @Column(name = "Cupon_Interes")
    private double CuponInteres;

    @Column(name = "Cuota")
    private double Cuota;

    @Column(name = "Amortizacion")
    private double Amortizacion;

    @Column(name = "Prima")
    private double Prima;

    @Column(name = "Escudo")
    private double Escudo;

    @Column(name = "Flujo_Emisor")
    private double FlujoEmisor;

    @Column(name = "Flujo_Emisor_Escudo")
    private double FlujoEmisorEscudo;

    @Column(name = "Flujo_Bonista")
    private double FlujoBonista;

    @Column(name = "Flujo_Act")
    private double FlujoAct;

    @Column(name = "Fa_Plazo")
    private double FaPlazo;

    @Column(name = "Convexidad")
    private double Convexidad;

    @ManyToOne
    @JoinColumn(name = "Id_Bono")
    private Bono Bonos;

    public FlujoCaja() {
    }

    public FlujoCaja(int idFlujoCaja, int periodo, LocalDate fechaProgramada, String plazoGracia, double bono, double bonoIndexado, double cuponInteres, double cuota, double amortizacion, double prima, double escudo, double flujoEmisor, double flujoEmisorEscudo, double flujoBonista, double flujoAct, double faPlazo, double convexidad, pe.edu.upc.contafacill.entities.Bono bonos) {
        IdFlujoCaja = idFlujoCaja;
        Periodo = periodo;
        FechaProgramada = fechaProgramada;
        PlazoGracia = plazoGracia;
        Bono = bono;
        BonoIndexado = bonoIndexado;
        CuponInteres = cuponInteres;
        Cuota = cuota;
        Amortizacion = amortizacion;
        Prima = prima;
        Escudo = escudo;
        FlujoEmisor = flujoEmisor;
        FlujoEmisorEscudo = flujoEmisorEscudo;
        FlujoBonista = flujoBonista;
        FlujoAct = flujoAct;
        FaPlazo = faPlazo;
        Convexidad = convexidad;
        Bonos = bonos;
    }

    public double getFlujoBonista() {
        return FlujoBonista;
    }

    public void setFlujoBonista(double flujoBonista) {
        FlujoBonista = flujoBonista;
    }

    public int getIdFlujoCaja() {
        return IdFlujoCaja;
    }

    public void setIdFlujoCaja(int idFlujoCaja) {
        IdFlujoCaja = idFlujoCaja;
    }

    public int getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(int periodo) {
        Periodo = periodo;
    }

    public LocalDate getFechaProgramada() {
        return FechaProgramada;
    }

    public void setFechaProgramada(LocalDate fechaProgramada) {
        FechaProgramada = fechaProgramada;
    }

    public String getPlazoGracia() {
        return PlazoGracia;
    }

    public void setPlazoGracia(String plazoGracia) {
        PlazoGracia = plazoGracia;
    }

    public double getBono() {
        return Bono;
    }

    public void setBono(double bono) {
        Bono = bono;
    }

    public double getBonoIndexado() {
        return BonoIndexado;
    }

    public void setBonoIndexado(double bonoIndexado) {
        BonoIndexado = bonoIndexado;
    }

    public double getCuponInteres() {
        return CuponInteres;
    }

    public void setCuponInteres(double cuponInteres) {
        CuponInteres = cuponInteres;
    }

    public double getCuota() {
        return Cuota;
    }

    public void setCuota(double cuota) {
        Cuota = cuota;
    }

    public double getAmortizacion() {
        return Amortizacion;
    }

    public void setAmortizacion(double amortizacion) {
        Amortizacion = amortizacion;
    }

    public double getPrima() {
        return Prima;
    }

    public void setPrima(double prima) {
        Prima = prima;
    }

    public double getEscudo() {
        return Escudo;
    }

    public void setEscudo(double escudo) {
        Escudo = escudo;
    }

    public double getFlujoEmisor() {
        return FlujoEmisor;
    }

    public void setFlujoEmisor(double flujoEmisor) {
        FlujoEmisor = flujoEmisor;
    }

    public double getFlujoEmisorEscudo() {
        return FlujoEmisorEscudo;
    }

    public void setFlujoEmisorEscudo(double flujoEmisorEscudo) {
        FlujoEmisorEscudo = flujoEmisorEscudo;
    }

    public double getFlujoAct() {
        return FlujoAct;
    }

    public void setFlujoAct(double flujoAct) {
        FlujoAct = flujoAct;
    }

    public double getFaPlazo() {
        return FaPlazo;
    }

    public void setFaPlazo(double faPlazo) {
        FaPlazo = faPlazo;
    }

    public double getConvexidad() {
        return Convexidad;
    }

    public void setConvexidad(double convexidad) {
        Convexidad = convexidad;
    }

    public pe.edu.upc.contafacill.entities.Bono getBonos() {
        return Bonos;
    }

    public void setBonos(pe.edu.upc.contafacill.entities.Bono bonos) {
        Bonos = bonos;
    }
}