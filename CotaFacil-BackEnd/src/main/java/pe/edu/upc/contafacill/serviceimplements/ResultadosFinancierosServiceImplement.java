package pe.edu.upc.contafacill.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.contafacill.entities.FlujoCaja;
import pe.edu.upc.contafacill.entities.ResultadosFinancieros;
import pe.edu.upc.contafacill.repositories.IResultadosFinancierosRepository;
import pe.edu.upc.contafacill.serviceinterfaces.IResultadosFinancierosService;

import java.util.List;

@Service
public class ResultadosFinancierosServiceImplement implements IResultadosFinancierosService {
    @Autowired
    private IResultadosFinancierosRepository resultadosFinancierosRepository;

    @Override
    public List<ResultadosFinancieros> list() {
        return resultadosFinancierosRepository.findAll();
    }

    @Override
    public void insert(ResultadosFinancieros resultadosFinancieros) {
        resultadosFinancierosRepository.save(resultadosFinancieros);
    }

    @Override
    public ResultadosFinancieros listId(int idResultadosFinancieros) {
        return resultadosFinancierosRepository.findById(idResultadosFinancieros).orElse(new ResultadosFinancieros());
    }

    @Override
    public void update(ResultadosFinancieros resultadosFinancieros) {
        resultadosFinancierosRepository.save(resultadosFinancieros);
    }

    @Override
    public void delete(int idResultadosFinancieros) {
        resultadosFinancierosRepository.deleteById(idResultadosFinancieros);
    }

    @Override
    public List<ResultadosFinancieros> list_bono_id(int idBono) {
        return resultadosFinancierosRepository.list_bono_id(idBono);
    }

    @Override
    public void deleteByIdBono(int idBono) {
        resultadosFinancierosRepository.deleteByIdBono(idBono);
    }
}