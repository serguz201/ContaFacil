package pe.edu.upc.contafacill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.contafacill.entities.FlujoCaja;

import java.util.List;

@Repository
public interface IFlujoCajaRepository extends JpaRepository<FlujoCaja, Integer> {
    @Query(value = "SELECT * FROM public.flujo_caja\n" +
            " WHERE id_bono = :idBono\n" +
            " ORDER BY id_flujo_caja ASC ", nativeQuery = true)
    public List<FlujoCaja> list_bono_id(@Param("idBono")int idBono);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM public.flujo_caja WHERE id_bono = :idBono", nativeQuery = true)
    public void deleteByIdBono(@Param("idBono") int idBono);
}
