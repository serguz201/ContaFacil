package pe.edu.upc.contafacill.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.contafacill.dtos.CatalogoMonedaDTO;
import pe.edu.upc.contafacill.entities.CatalogoMoneda;
import pe.edu.upc.contafacill.serviceinterfaces.ICatalogoMonedaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogo")
public class CatalogoMonedaController {
    @Autowired
    private ICatalogoMonedaService catalogoMonedaService;

    @GetMapping
    public List<CatalogoMonedaDTO> listar() {
        return catalogoMonedaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CatalogoMonedaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CatalogoMonedaDTO CatalogoMonedaDTO) {
        ModelMapper m = new ModelMapper();
        CatalogoMoneda catalogoMoneda = m.map(CatalogoMonedaDTO, CatalogoMoneda.class);
        catalogoMonedaService.insert(catalogoMoneda);
    }
    @PutMapping
    public void modificar(@RequestBody CatalogoMonedaDTO CatalogoMonedaDTO) {
        ModelMapper m = new ModelMapper();
        CatalogoMoneda catalogoMoneda = m.map(CatalogoMonedaDTO, CatalogoMoneda.class);
        catalogoMonedaService.update(catalogoMoneda);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        catalogoMonedaService.delete(id);
    }

    @GetMapping("/{id}")
    public CatalogoMonedaDTO listarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        CatalogoMonedaDTO dto=m.map(catalogoMonedaService.listId(id),CatalogoMonedaDTO.class);
        return dto;
    }
}
