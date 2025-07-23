package pe.edu.upc.contafacill.serviceinterfaces;

import pe.edu.upc.contafacill.entities.Users;

import java.util.List;

public interface IUsersService {
    public void insert(Users users);
    public List<Users> list();
    public Users listById(int id);
    public void update(Users users);
    public void delete(int id);
}
