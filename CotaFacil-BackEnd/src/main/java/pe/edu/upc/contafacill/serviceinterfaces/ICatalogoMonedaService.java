package pe.edu.upc.contafacill.serviceinterfaces;

import pe.edu.upc.contafacill.entities.CatalogoMoneda;

import java.util.List;

public interface ICatalogoMonedaService {
    public List<CatalogoMoneda> list();
    public void insert(CatalogoMoneda catalogoMoneda);
    public void update(CatalogoMoneda catalogoMoneda);
    public void delete(int catalogoMonedaId);
    public CatalogoMoneda listId(int id);
}
