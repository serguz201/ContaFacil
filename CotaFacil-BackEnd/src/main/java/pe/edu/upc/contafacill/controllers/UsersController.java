package pe.edu.upc.contafacill.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.contafacill.dtos.UsersDTO;
import pe.edu.upc.contafacill.entities.Users;
import pe.edu.upc.contafacill.serviceinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService usersService;

    @GetMapping
    public List<UsersDTO> listar() {
        return usersService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody UsersDTO UsersDTO) {
        ModelMapper m = new ModelMapper();
        Users users = m.map(UsersDTO, Users.class);
        usersService.insert(users);
    }
    @PutMapping
    public void modificar(@RequestBody UsersDTO UsersDTO) {
        ModelMapper m = new ModelMapper();
        Users users = m.map(UsersDTO, Users.class);
        usersService.update(users);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        usersService.delete(id);
    }

    @GetMapping("/{id}")
    public UsersDTO listarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        UsersDTO dto=m.map(usersService.listById(id),UsersDTO.class);
        return dto;
    }

}
