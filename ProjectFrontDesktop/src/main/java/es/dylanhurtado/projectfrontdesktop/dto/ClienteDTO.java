package es.dylanhurtado.projectfrontdesktop.dto;

import java.util.List;
import java.util.UUID;

public class ClienteDTO {
    private UUID id;
    private String nombre;
    private String correo;
    private String password;
    private String foto;
    private List<AlquilerDTO> alquileres;
    private LoginDTO login;
    public ClienteDTO() {
    }

    public ClienteDTO(UUID id, String nombre, String correo, String password, String foto, List<AlquilerDTO> alquileres) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.foto = foto;
        this.alquileres = alquileres;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<AlquilerDTO> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<AlquilerDTO> alquileres) {
        this.alquileres = alquileres;
    }

    public LoginDTO getLogin() {
        return login;
    }

    public void setLogin(LoginDTO login) {
        this.login = login;
    }
}
