package es.dylanhurtado.projectfrontdesktop.dto;

import java.util.UUID;

public class AlquilerDTO {
    private UUID id;
    private int inicio;
    private int fin;
    private double coste;
    private InfraestructuraDTO infraestructura;
    private ClienteDTO cliente;
    private int year;
    private int month;
    private int day;

    public AlquilerDTO(UUID id, int inicio, int fin, double coste, InfraestructuraDTO infraestructura, ClienteDTO cliente, int year, int month, int day) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.coste = coste;
        this.infraestructura = infraestructura;
        this.cliente = cliente;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public AlquilerDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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
