package pe.edu.upc.contafacill.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.contafacill.dtos.FlujoCajaDTO;
import pe.edu.upc.contafacill.entities.FlujoCaja;
import pe.edu.upc.contafacill.serviceinterfaces.IFlujoCajaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flujo")
public class FlujoCajaController {
    @Autowired
    private IFlujoCajaService flujoCajaService;

    @GetMapping
    public List<FlujoCajaDTO> listar() {
        return flujoCajaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, FlujoCajaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody FlujoCajaDTO flujoCajaDTO) {
        ModelMapper m = new ModelMapper();
        FlujoCaja flujoCaja = m.map(flujoCajaDTO, FlujoCaja.class);
        flujoCajaService.insert(flujoCaja);
    }
    @PutMapping
    public void modificar(@RequestBody FlujoCajaDTO flujoCajaDTO) {
        ModelMapper m = new ModelMapper();
        FlujoCaja flujoCaja = m.map(flujoCajaDTO, FlujoCaja.class);
        flujoCajaService.update(flujoCaja);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        flujoCajaService.delete(id);
    }

    @GetMapping("/{id}")
    public FlujoCajaDTO listarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        FlujoCajaDTO dto=m.map(flujoCajaService.listId(id),FlujoCajaDTO.class);
        return dto;
    }
    @GetMapping("/cajaxbono/{id}")
    public List<FlujoCajaDTO> list_bono_id(@PathVariable("id") int id){
        return flujoCajaService.list_bono_id(id).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, FlujoCajaDTO.class);
        }).collect(Collectors.toList());
    }
}
