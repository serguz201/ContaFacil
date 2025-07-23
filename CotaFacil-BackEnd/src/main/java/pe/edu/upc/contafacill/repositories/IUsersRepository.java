package pe.edu.upc.contafacill.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.contafacill.entities.FlujoCaja;
import pe.edu.upc.contafacill.entities.Users;

import java.util.List;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer> {
}
