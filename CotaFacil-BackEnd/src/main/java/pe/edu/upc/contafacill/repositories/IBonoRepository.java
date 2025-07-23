package pe.edu.upc.contafacill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.contafacill.entities.Bono;

import java.util.List;

@Repository
public interface IBonoRepository extends JpaRepository<Bono, Integer> {
    @Query("SELECT b FROM Bono b WHERE b.IdUsers.IdUser = :idUser")
    List<Bono> findByUserId(@Param("idUser") int idUser);
}