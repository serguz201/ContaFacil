package pe.edu.upc.contafacill.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.contafacill.entities.Bono;

public class ResultadosFinancierosDTO {
    private int IdResultadosFinancieros;
    private double PrecioActual;
    private double Utilidad;
    private double Duracion;
    private double Convexidad;
    private double DuracionModificada;
    private double Total;
    private double PrecioMaxMercado;
    private double TceaEmisor;
    private double TceaEmisorEscudo;
    private double TreaBonista;
    private Bono Bonos;

    public int getIdResultadosFinancieros() {
        return IdResultadosFinancieros;
    }

    public void setIdResultadosFinancieros(int idResultadosFinancieros) {
        IdResultadosFinancieros = idResultadosFinancieros;
    }

    public double getPrecioActual() {
        return PrecioActual;
    }

    public void setPrecioActual(double precioActual) {
        PrecioActual = precioActual;
    }

    public double getUtilidad() {
        return Utilidad;
    }

    public void setUtilidad(double utilidad) {
        Utilidad = utilidad;
    }

    public double getDuracion() {
        return Duracion;
    }

    public void setDuracion(double duracion) {
        Duracion = duracion;
    }

    public double getConvexidad() {
        return Convexidad;
    }

    public void setConvexidad(double convexidad) {
        Convexidad = convexidad;
    }

    public double getDuracionModificada() {
        return DuracionModificada;
    }

    public void setDuracionModificada(double duracionModificada) {
        DuracionModificada = duracionModificada;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }

    public double getPrecioMaxMercado() {
        return PrecioMaxMercado;
    }

    public void setPrecioMaxMercado(double precioMaxMercado) {
        PrecioMaxMercado = precioMaxMercado;
    }

    public double getTceaEmisor() {
        return TceaEmisor;
    }

    public void setTceaEmisor(double tceaEmisor) {
        TceaEmisor = tceaEmisor;
    }

    public double getTceaEmisorEscudo() {
        return TceaEmisorEscudo;
    }

    public void setTceaEmisorEscudo(double tceaEmisorEscudo) {
        TceaEmisorEscudo = tceaEmisorEscudo;
    }

    public double getTreaBonista() {
        return TreaBonista;
    }

    public void setTreaBonista(double treaBonista) {
        TreaBonista = treaBonista;
    }

    public Bono getBonos() {
        return Bonos;
    }

    public void setBonos(Bono bonos) {
        Bonos = bonos;
    }
}
