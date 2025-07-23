package pe.edu.upc.contafacill.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ResultadosFinancieros")
public class ResultadosFinancieros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdResultadosFinancieros;

    @Column(name = "Precio_Actual")
    private double PrecioActual;

    @Column(name = "Utilidad")
    private double Utilidad;

    @Column(name = "Duracion")
    private double Duracion;

    @Column(name = "Convexidad")
    private double Convexidad;

    @Column(name = "Duracion_Modificada")
    private double DuracionModificada;

    @Column(name = "Total")
    private double Total;

    @Column(name = "Precio_Max_Mercado")
    private double PrecioMaxMercado;

    @Column(name = "TCEA_Emisor")
    private double TceaEmisor;

    @Column(name = "TCEA_Emisor_Escudo")
    private double TceaEmisorEscudo;

    @Column(name = "TREA_Bonista")
    private double TreaBonista;

    @ManyToOne
    @JoinColumn(name = "Id_Bonos", nullable = false)
    private Bono bonos;

    public ResultadosFinancieros() {
    }

    public ResultadosFinancieros(int idResultadosFinancieros, double precioActual, double utilidad, double duracion, double convexidad, double duracionModificada, double total, double precioMaxMercado, double tceaEmisor, double tceaEmisorEscudo, double treaBonista, Bono bonos) {
        IdResultadosFinancieros = idResultadosFinancieros;
        PrecioActual = precioActual;
        Utilidad = utilidad;
        Duracion = duracion;
        Convexidad = convexidad;
        DuracionModificada = duracionModificada;
        Total = total;
        PrecioMaxMercado = precioMaxMercado;
        TceaEmisor = tceaEmisor;
        TceaEmisorEscudo = tceaEmisorEscudo;
        TreaBonista = treaBonista;
        this.bonos = bonos;
    }

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
        return bonos;
    }

    public void setBonos(Bono bonos) {
        this.bonos = bonos;
    }
}
