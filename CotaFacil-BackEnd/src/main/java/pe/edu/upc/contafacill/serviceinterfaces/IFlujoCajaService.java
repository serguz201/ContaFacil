package pe.edu.upc.contafacill.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.contafacill.entities.FlujoCaja;

import java.util.List;

public interface IFlujoCajaService {
    public List<FlujoCaja> list();
    public void insert(FlujoCaja flujoCaja);
    public FlujoCaja listId(int idFlujoCaja);
    public void update(FlujoCaja flujoCaja);
    public void delete(int idFlujoCaja);
    public List<FlujoCaja> list_bono_id(int idBono);
    public void deleteByIdBono(int idBono);
}
