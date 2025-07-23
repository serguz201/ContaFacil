package pe.edu.upc.contafacill.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.contafacill.entities.CatalogoMoneda;
import pe.edu.upc.contafacill.entities.Users;

import java.time.LocalDate;

public class BonoDTO {
    private int IdBono;
    private String NombreBono;
    private double ValorNominal;
    private int NumeroAños;
    private String FrecuenciaCupon;
    private int DiasPorAno;
    private String TipoTasa;
    private String Capitalizacion;
    private double TasaInteres;
    private double TasaAnualDescuento;
    private double Impuesto;
    private LocalDate FechaEmision;
    private double Inflacion;
    private String PlazoTipo;
    private Integer PlazoPeridos;
    private double Prima;
    private double CostesInicialesBonista;
    private double CostesInicialesOtros;
    private Boolean Emitido;
    private Users IdUsers;
    private CatalogoMoneda IdCatalogoMoneda;

    public double getTasaInteres() {
        return TasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        TasaInteres = tasaInteres;
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
