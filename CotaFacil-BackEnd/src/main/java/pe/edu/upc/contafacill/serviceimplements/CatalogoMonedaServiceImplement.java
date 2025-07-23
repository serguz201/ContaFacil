package pe.edu.upc.contafacill.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.contafacill.entities.CatalogoMoneda;
import pe.edu.upc.contafacill.repositories.ICatalogoMonedaRepository;
import pe.edu.upc.contafacill.serviceinterfaces.ICatalogoMonedaService;

import java.util.List;

@Service
public class CatalogoMonedaServiceImplement implements ICatalogoMonedaService {
    @Autowired
    private ICatalogoMonedaRepository catalogoMonedaRepository;

    @Override
    public List<CatalogoMoneda> list() {
        return catalogoMonedaRepository.findAll();
    }

    @Override
    public void insert(CatalogoMoneda catalogoMoneda) {
        catalogoMonedaRepository.save(catalogoMoneda);
    }

    @Override
    public void update(CatalogoMoneda catalogoMoneda) {
        catalogoMonedaRepository.save(catalogoMoneda);
    }

    @Override
    public void delete(int catalogoMonedaId) {
        catalogoMonedaRepository.deleteById(catalogoMonedaId);
    }

    @Override
    public CatalogoMoneda listId(int id) {
        return catalogoMonedaRepository.findById(id).orElse(new CatalogoMoneda());
    }
}
