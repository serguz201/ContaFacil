package pe.edu.upc.contafacill.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Bono")
public class Bono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Bono")
    private int IdBono;

    @Column(name = "Nombre_Bono", nullable = false, length = 30)
    private String NombreBono;

    @Column(name = "Valor_Nominal", nullable = false)
    private double ValorNominal;

    @Column(name = "Numero_Años", nullable = false)
    private int NumeroAños;

    @Column(name = "Frecuencia_Cupon", nullable = false, length = 30)
    private String FrecuenciaCupon;

    @Column(name = "Dias_Por_Ano", nullable = false)
    private int DiasPorAno;

    @Column(name = "Tipo_Tasa", nullable = false, length = 30)
    private String TipoTasa;

    @Column(name = "Capitalizacion", length = 30)
    private String Capitalizacion;

    @Column(name = "Tasa_Interes", nullable = false)
    private double TasaInteres;

    @Column(name = "Tasa_Anual_Descuento", nullable = false)
    private double TasaAnualDescuento;

    @Column(name = "Impuesto", nullable = false)
    private double Impuesto;

    @Column(name = "Fecha_Emision", nullable = false)
    private LocalDate FechaEmision;

    @Column(name = "Inflacion", nullable = false)
    private double Inflacion;

    @Column(name = "Plazo_Tipo", nullable = false, length = 30)
    private String PlazoTipo;

    @Column(name = "Plazo_Peridos")
    private Integer PlazoPeridos;

    @Column(name = "Prima", nullable = false)
    private double Prima;

    @Column(name = "Costes_Iniciales_Bonista", nullable = false)
    private double CostesInicialesBonista;

    @Column(name = "Costes_Iniciales_Otros", nullable = false)
    private double CostesInicialesOtros;

    @ManyToOne
    @JoinColumn(name = "IdUser")
    private Users IdUsers;

    @ManyToOne
    @JoinColumn(name = "IdConfiguracion")
    private CatalogoMoneda IdCatalogoMoneda;

    @Column(name = "Emitido")
    private Boolean Emitido;

    @OneToMany(mappedBy = "Bonos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlujoCaja> flujoCajas;

    @OneToMany(mappedBy = "bonos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResultadosFinancieros> resultadosFinancieros;

    public Bono() {
    }

    public Bono(int idBono, Boolean emitido, String nombreBono, double valorNominal, int numeroAños, String frecuenciaCupon, int diasPorAno, String tipoTasa, String capitalizacion, double tasaInteres, double tasaAnualDescuento, double impuesto, LocalDate fechaEmision, double inflacion, String plazoTipo, Integer plazoPeridos, double prima, double costesInicialesBonista, double costesInicialesOtros, Users idUsers, CatalogoMoneda idCatalogoMoneda) {
        IdBono = idBono;
        NombreBono = nombreBono;
        ValorNominal = valorNominal;
        NumeroAños = numeroAños;
        FrecuenciaCupon = frecuenciaCupon;
        DiasPorAno = diasPorAno;
        TipoTasa = tipoTasa;
        Capitalizacion = capitalizacion;
        TasaInteres = tasaInteres;
        TasaAnualDescuento = tasaAnualDescuento;
        Impuesto = impuesto;
        FechaEmision = fechaEmision;
        Inflacion = inflacion;
        PlazoTipo = plazoTipo;
        PlazoPeridos = plazoPeridos;
        Prima = prima;
        CostesInicialesBonista = costesInicialesBonista;
        CostesInicialesOtros = costesInicialesOtros;
        IdUsers = idUsers;
        IdCatalogoMoneda = idCatalogoMoneda;
        Emitido = emitido;
    }

    public int getIdBono() {
        return IdBono;
    }

    public void setIdBono(int idBono) {
        IdBono = idBono;
    }

    public String getNombreBono() {
        return NombreBono;
    }

    public void setNombreBono(String nombreBono) {
        NombreBono = nombreBono;
    }

    public double getValorNominal() {
        return ValorNominal;
    }

    public void setValorNominal(double valorNominal) {
        ValorNominal = valorNominal;
    }

    public int getNumeroAños() {
        return NumeroAños;
    }

    public void setNumeroAños(int numeroAños) {
        NumeroAños = numeroAños;
    }

    public String getFrecuenciaCupon() {
        return FrecuenciaCupon;
    }

    public void setFrecuenciaCupon(String frecuenciaCupon) {
        FrecuenciaCupon = frecuenciaCupon;
    }

    public int getDiasPorAno() {
        return DiasPorAno;
    }

    public void setDiasPorAno(int diasPorAno) {
        DiasPorAno = diasPorAno;
    }

    public String getTipoTasa() {
        return TipoTasa;
    }

    public void setTipoTasa(String tipoTasa) {
        TipoTasa = tipoTasa;
    }

    public String getCapitalizacion() {
        return Capitalizacion;
    }

    public void setCapitalizacion(String capitalizacion) {
        Capitalizacion = capitalizacion;
    }

    public double getTasaInteres() {
        return TasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        TasaInteres = tasaInteres;
    }

    public double getTasaAnualDescuento() {
        return TasaAnualDescuento;
    }

    public void setTasaAnualDescuento(double tasaAnualDescuento) {
        TasaAnualDescuento = tasaAnualDescuento;
    }

    public double getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(double impuesto) {
        Impuesto = impuesto;
    }

    public LocalDate getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        FechaEmision = fechaEmision;
    }

    public double getInflacion() {
        return Inflacion;
    }

    public void setInflacion(double inflacion) {
        Inflacion = inflacion;
    }

    public String getPlazoTipo() {
        return PlazoTipo;
    }

    public void setPlazoTipo(String plazoTipo) {
        PlazoTipo = plazoTipo;
    }

    public Integer getPlazoPeridos() {
        return PlazoPeridos;
    }

    public void setPlazoPeridos(Integer plazoPeridos) {
        PlazoPeridos = plazoPeridos;
    }

    public double getPrima() {
        return Prima;
    }

    public void setPrima(double prima) {
        Prima = prima;
    }

    public double getCostesInicialesBonista() {
        return CostesInicialesBonista;
    }

    public void setCostesInicialesBonista(double costesInicialesBonista) {
        CostesInicialesBonista = costesInicialesBonista;
    }

    public double getCostesInicialesOtros() {
        return CostesInicialesOtros;
    }

    public void setCostesInicialesOtros(double costesInicialesOtros) {
        CostesInicialesOtros = costesInicialesOtros;
    }

    public Users getIdUsers() {
        return IdUsers;
    }

    public void setIdUsers(Users idUsers) {
        IdUsers = idUsers;
    }

    public CatalogoMoneda getIdCatalogoMoneda() {
        return IdCatalogoMoneda;
    }

    public void setIdCatalogoMoneda(CatalogoMoneda idCatalogoMoneda) {
        IdCatalogoMoneda = idCatalogoMoneda;
    }

    public Boolean getEmitido() {
        return Emitido;
    }

    public void setEmitido(Boolean emitido) {
        Emitido = emitido;
    }


}