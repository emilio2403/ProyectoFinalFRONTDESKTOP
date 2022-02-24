package es.dylanhurtado.projectfrontdesktop.dto;

import java.time.LocalDateTime;
import java.util.List;

public class InfraestructuraDTO {
    private long id;
    private List<AlquilerDTO> alquileres;
    private String tipo;
    private String foto;
    private LocalDateTime apertura;
    private LocalDateTime cierre;
    private String descripcion;
    private Double price;


    public InfraestructuraDTO() {
    }

    public InfraestructuraDTO(long id, List<AlquilerDTO> alquileres, String tipo, String foto, LocalDateTime apertura, LocalDateTime cierre, String descripcion, Double price) {
        this.id = id;
        this.alquileres = alquileres;
        this.tipo = tipo;
        this.foto = foto;
        this.apertura = apertura;
        this.cierre = cierre;
        this.descripcion = descripcion;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public LocalDateTime getApertura() {
        return apertura;
    }

    public void setApertura(LocalDateTime apertura) {
        this.apertura = apertura;
    }

    public LocalDateTime getCierre() {
        return cierre;
    }

    public void setCierre(LocalDateTime cierre) {
        this.cierre = cierre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
