package pe.edu.upc.contafacill.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.contafacill.entities.Users;
import pe.edu.upc.contafacill.repositories.IUsersRepository;
import pe.edu.upc.contafacill.serviceinterfaces.IUsersService;

import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {
    @Autowired
    private IUsersRepository uR;


    @Override
    public void insert(Users users) {
        uR.save(users);
    }

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public Users listById(int id) {
        return uR.findById(id).orElse(new Users());
    }

    @Override
    public void update(Users users) {
        uR.save(users);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }
}
