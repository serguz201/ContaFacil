package pe.edu.upc.contafacill.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Catalogo_Moneda")
public class CatalogoMoneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdCatalogoMoneda;
    @Column(name = "Moneda",unique = true, length = 30)
    private String Moneda;
    @Column(name = "Tipo_Cambio")
    private double TipoCambio;

    public CatalogoMoneda() {
    }

    public CatalogoMoneda(int idCatalogoMoneda, String moneda, double tipoCambio) {
        IdCatalogoMoneda = idCatalogoMoneda;
        Moneda = moneda;
        TipoCambio = tipoCambio;
    }

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
