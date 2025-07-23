package pe.edu.upc.contafacill.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdUser;
    @Column(name = "Username",unique = true, length = 30)
    private String Username;
    @Column(name = "Password", length = 200)
    private String Password;
    @Column(name = "Nombre", nullable = false, length = 30)
    private String Nombre;
    @Column(name = "Apellido", nullable = false, length = 30)
    private String Apellido;
    @Column(name = "Direccion", nullable = false, length = 50)
    private String Direccion;
    @Column(name = "Email", nullable = false, length = 50)
    private String Email;
    @Column(name = "Genero", nullable = false, length = 9)
    private String Genero;
    @Column(name = "FechaRegistro",nullable = false)
    private LocalDate FechaRegistro;
    @Column(name = "Enabled")
    private Boolean Enabled;

    public Users() {
    }

    public Users(int idUser, String username, String password, String nombre, String apellido, String direccion, String email, String genero, LocalDate fechaRegistro, Boolean enabled, List<pe.edu.upc.contafacill.entities.Role> role) {
        IdUser = idUser;
        Username = username;
        Password = password;
        Nombre = nombre;
        Apellido = apellido;
        Direccion = direccion;
        Email = email;
        Genero = genero;
        FechaRegistro = fechaRegistro;
        Enabled = enabled;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public LocalDate getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        FechaRegistro = fechaRegistro;
    }

    public Boolean getEnabled() {
        return Enabled;
    }

    public void setEnabled(Boolean enabled) {
        Enabled = enabled;
    }

}
