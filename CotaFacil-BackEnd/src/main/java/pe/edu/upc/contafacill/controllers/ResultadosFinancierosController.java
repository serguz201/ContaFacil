package pe.edu.upc.contafacill.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.contafacill.dtos.ResultadosFinancierosDTO;
import pe.edu.upc.contafacill.entities.ResultadosFinancieros;
import pe.edu.upc.contafacill.serviceinterfaces.IResultadosFinancierosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resultados")
public class ResultadosFinancierosController {
    @Autowired
    private IResultadosFinancierosService resultadosFinancierosService;

    @GetMapping
    public List<ResultadosFinancierosDTO> listar() {
        return resultadosFinancierosService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ResultadosFinancierosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ResultadosFinancierosDTO resultadosFinancierosDTO) {
        ModelMapper m = new ModelMapper();
        ResultadosFinancieros resultadosFinancieros = m.map(resultadosFinancierosDTO, ResultadosFinancieros.class);
        resultadosFinancierosService.insert(resultadosFinancieros);
    }
    @PutMapping
    public void modificar(@RequestBody ResultadosFinancierosDTO resultadosFinancierosDTO) {
        ModelMapper m = new ModelMapper();
        ResultadosFinancieros resultadosFinancieros = m.map(resultadosFinancierosDTO, ResultadosFinancieros.class);
        resultadosFinancierosService.update(resultadosFinancieros);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id){
        resultadosFinancierosService.delete(id);
    }

    @GetMapping("/{id}")
    public ResultadosFinancierosDTO listarId(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        ResultadosFinancierosDTO dto=m.map(resultadosFinancierosService.listId(id),ResultadosFinancierosDTO.class);
        return dto;
    }
    @GetMapping("/resultadoxbono/{id}")
    public List<ResultadosFinancierosDTO> list_bono_id(@PathVariable("id") int id){
        return resultadosFinancierosService.list_bono_id(id).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ResultadosFinancierosDTO.class);
        }).collect(Collectors.toList());
    }
}
