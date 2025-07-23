package pe.edu.upc.contafacill.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.contafacill.dtos.RoleDTO;
import pe.edu.upc.contafacill.entities.Role;
import pe.edu.upc.contafacill.entities.Users;
import pe.edu.upc.contafacill.serviceinterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping
    public List<RoleDTO> listar() {
        return roleService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody RoleDTO roledto) {
        Role role = new Role();
        role.setId(roledto.getId());
        role.setRol(roledto.getRol());

        Users user = new Users();
        user.setIdUser(roledto.getUserId());
        role.setUser(user);

        roleService.insert(role);
    }
    @PutMapping
    public void modificar(@RequestBody RoleDTO roledto) {
        ModelMapper m = new ModelMapper();
        Role role = m.map(roledto, Role.class);
        roleService.update(role);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){
        roleService.delete(id);
    }

    @GetMapping("/{id}")
    public RoleDTO listarId(@PathVariable("id") Long id){
        ModelMapper m=new ModelMapper();
        RoleDTO dto=m.map(roleService.listId(id),RoleDTO.class);
        return dto;
    }
}
