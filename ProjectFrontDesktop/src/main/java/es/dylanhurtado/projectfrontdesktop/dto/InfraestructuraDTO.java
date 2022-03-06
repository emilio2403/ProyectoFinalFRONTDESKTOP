package es.dylanhurtado.projectfrontdesktop.dto;

import java.util.List;
import java.util.UUID;

public class InfraestructuraDTO {
    private UUID id;
    private List<AlquilerDTO> alquileres;
    private String nombre;
    private String tipo;
    private String foto;
    private int apertura;
    private int cierre;
    private double coste;


    public InfraestructuraDTO() {
    }

    public InfraestructuraDTO(UUID id, List<AlquilerDTO> alquileres, String nombre, String tipo, String foto, int apertura, int cierre, double coste) {
        this.id = id;
        this.alquileres = alquileres;
        this.nombre = nombre;
        this.tipo = tipo;
        this.foto = foto;
        this.apertura = apertura;
        this.cierre = cierre;
        this.coste = coste;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<AlquilerDTO> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<AlquilerDTO> alquileres) {
        this.alquileres = alquileres;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getApertura() {
        return apertura;
    }

    public void setApertura(int apertura) {
        this.apertura = apertura;
    }

    public int getCierre() {
        return cierre;
    }

    public void setCierre(int cierre) {
        this.cierre = cierre;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }
}
