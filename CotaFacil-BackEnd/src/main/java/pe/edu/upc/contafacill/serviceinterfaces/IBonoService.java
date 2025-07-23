package pe.edu.upc.contafacill.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.contafacill.entities.Bono;

import java.util.List;

public interface IBonoService {
    public List<Bono> list();
    public void insert(Bono bono);
    public void update(Bono bono);
    public void delete(int bonoId);
    public Bono listId(int id);
    public List<Bono> findByUserId(int idUser);
}
