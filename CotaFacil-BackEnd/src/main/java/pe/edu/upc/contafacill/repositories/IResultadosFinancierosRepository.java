package pe.edu.upc.contafacill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.contafacill.entities.FlujoCaja;
import pe.edu.upc.contafacill.entities.ResultadosFinancieros;

import java.util.List;

@Repository
public interface IResultadosFinancierosRepository extends JpaRepository<ResultadosFinancieros, Integer> {
    @Query(value = "SELECT * FROM public.resultados_financieros\n" +
            " WHERE id_bonos = :idBono\n" +
            " ORDER BY id_resultados_financieros ASC ", nativeQuery = true)
    public List<ResultadosFinancieros> list_bono_id(@Param("idBono")int idBono);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM public.resultados_financieros WHERE id_bonos = :idBono", nativeQuery = true)
    void deleteByIdBono(@Param("idBono") int idBono);
}
