package pe.edu.upc.contafacill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.contafacill.entities.CatalogoMoneda;

@Repository
public interface ICatalogoMonedaRepository extends JpaRepository<CatalogoMoneda, Integer> {
}
