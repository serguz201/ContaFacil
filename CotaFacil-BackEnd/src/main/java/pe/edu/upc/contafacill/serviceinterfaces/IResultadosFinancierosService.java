package pe.edu.upc.contafacill.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.contafacill.entities.FlujoCaja;
import pe.edu.upc.contafacill.entities.ResultadosFinancieros;

import java.util.List;

public interface IResultadosFinancierosService {
    public List<ResultadosFinancieros> list();
    public void insert(ResultadosFinancieros resultadosFinancieros);
    public ResultadosFinancieros listId(int idResultadosFinancieros);
    public void update(ResultadosFinancieros resultadosFinancieros);
    public void delete(int idResultadosFinancieros);
    public List<ResultadosFinancieros> list_bono_id(int idBono);
    void deleteByIdBono(int idBono);
}
