package pe.edu.upc.contafacill.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.contafacill.entities.FlujoCaja;
import pe.edu.upc.contafacill.repositories.IFlujoCajaRepository;
import pe.edu.upc.contafacill.serviceinterfaces.IFlujoCajaService;

import java.util.List;

@Service
public class FlujoCajaServiceImplement implements IFlujoCajaService {
    @Autowired
    private IFlujoCajaRepository flujoCajaRepository;

    @Override
    public List<FlujoCaja> list() {
        return flujoCajaRepository.findAll();
    }

    @Override
    public void insert(FlujoCaja flujoCaja) {
        flujoCajaRepository.save(flujoCaja);
    }

    @Override
    public FlujoCaja listId(int idFlujoCaja) {
        return flujoCajaRepository.findById(idFlujoCaja).orElse(new FlujoCaja());
    }

    @Override
    public void update(FlujoCaja flujoCaja) {
        flujoCajaRepository.save(flujoCaja);
    }

    @Override
    public void delete(int idFlujoCaja) {
        flujoCajaRepository.deleteById(idFlujoCaja);
    }

    @Override
    public List<FlujoCaja> list_bono_id(int idBono) {
        return flujoCajaRepository.list_bono_id(idBono);
    }

    @Override
    public void deleteByIdBono(int idBono) {
        flujoCajaRepository.deleteByIdBono(idBono);
    }


}

