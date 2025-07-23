package pe.edu.upc.contafacill.serviceinterfaces;

import pe.edu.upc.contafacill.entities.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> list();

    public void insert(Role rol);
    public Role listId(Long idRol);
    public void update(Role rol);
    public void delete(Long idRol);
}
