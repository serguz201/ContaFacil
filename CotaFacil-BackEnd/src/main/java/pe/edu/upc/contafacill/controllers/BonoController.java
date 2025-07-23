package pe.edu.upc.contafacill.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.contafacill.dtos.BonoDTO;
import pe.edu.upc.contafacill.entities.Bono;
import pe.edu.upc.contafacill.serviceinterfaces.IBonoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bono")
public class BonoController {
    @Autowired
    private IBonoService bonoService;

    @GetMapping
    public List<BonoDTO> listar() {
        return bonoService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, BonoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody BonoDTO bonosDTO) {
        ModelMapper m = new ModelMapper();
        Bono bonos = m.map(bonosDTO, Bono.class);
        bonoService.insert(bonos);
    }
    @PutMapping
    public void modificar(@RequestBody BonoDTO bonosDTO) {
        ModelMapper m = new ModelMapper();
        Bono bonos = m.map(bonosDTO, Bono.class);
        bonoService.update(bonos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        bonoService.delete(id);
    }

    @GetMapping("/{id}")
    public BonoDTO listarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        BonoDTO dto=m.map(bonoService.listId(id),BonoDTO.class);
        return dto;
    }

    @GetMapping("/usuario/{idUser}")
    public List<BonoDTO> listarPorUsuario(@PathVariable("idUser") int idUser) {
        return bonoService.findByUserId(idUser).stream().map(bono -> {
            ModelMapper m = new ModelMapper();
            return m.map(bono, BonoDTO.class);
        }).collect(Collectors.toList());
    }


}
