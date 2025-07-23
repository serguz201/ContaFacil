package pe.edu.upc.contafacill.dtos;

import jakarta.persistence.Column;

public class CatalogoMonedaDTO {
    private int IdCatalogoMoneda;
    private String Moneda;
    private double TipoCambio;

    public int getIdCatalogoMoneda() {
        return IdCatalogoMoneda;
    }

    public void setIdCatalogoMoneda(int idCatalogoMoneda) {
        IdCatalogoMoneda = idCatalogoMoneda;
    }

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String moneda) {
        Moneda = moneda;
    }

    public double getTipoCambio() {
        return TipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        TipoCambio = tipoCambio;
    }
}
