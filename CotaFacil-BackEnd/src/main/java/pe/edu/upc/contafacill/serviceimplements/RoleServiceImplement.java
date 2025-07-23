package pe.edu.upc.contafacill.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.contafacill.entities.Role;
import pe.edu.upc.contafacill.repositories.IRoleRepository;
import pe.edu.upc.contafacill.serviceinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @Override
    public void insert(Role rol) {
        roleRepository.save(rol);
    }

    @Override
    public Role listId(Long idRol) {
        return roleRepository.findById(idRol).orElse(new Role());
    }

    @Override
    public void update(Role rol) {
        roleRepository.save(rol);
    }

    @Override
    public void delete(Long idRol) {
        roleRepository.deleteById(idRol);
    }
}

