package pe.edu.upc.contafacill.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.contafacill.entities.Bono;

import java.time.LocalDate;

public class FlujoCajaDTO {
    private int IdFlujoCaja;
    private int Periodo;
    private LocalDate FechaProgramada;
    private String PlazoGracia;
    private double Bono;
    private double BonoIndexado;
    private double CuponInteres;
    private double Cuota;
    private double Amortizacion;
    private double Prima;
    private double Escudo;
    private double FlujoEmisor;
    private double FlujoEmisorEscudo;
    private double FlujoBonista;
    private double FlujoAct;
    private double FaPlazo;
    private double Convexidad;
    private Bono Bonos;

    public double getAmortizacion() {
        return Amortizacion;
    }

    public void setAmortizacion(double amortizacion) {
        Amortizacion = amortizacion;
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

    public double getFlujoBonista() {
        return FlujoBonista;
    }

    public void setFlujoBonista(double flujoBonista) {
        FlujoBonista = flujoBonista;
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
