package es.dylanhurtado.projectfrontdesktop.dto;

import java.time.LocalDateTime;

public class AlquilerDTO {
    private long id;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private double coste;
    private InfraestructuraDTO infraestructura;
    private ClienteDTO cliente;

    public AlquilerDTO(long id, LocalDateTime inicio, LocalDateTime fin, double coste, InfraestructuraDTO infraestructura, ClienteDTO cliente) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.coste = coste;
        this.infraestructura = infraestructura;
        this.cliente = cliente;
    }

    public AlquilerDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public InfraestructuraDTO getInfraestructura() {
        return infraestructura;
    }

    public void setInfraestructura(InfraestructuraDTO infraestructura) {
        this.infraestructura = infraestructura;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
}
