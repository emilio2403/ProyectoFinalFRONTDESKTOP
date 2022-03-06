package es.dylanhurtado.projectfrontdesktop.model;

import java.time.LocalDate;
import java.util.UUID;

public class Reserva {
    private UUID id;
    private String image;
    private Double price;
    private String username;
    private String sportType;
    private Pista pista;
    private int inicio;
    private int fin;
    private LocalDate date;

    public Reserva() {
    }

    public Reserva(UUID id, String image, String sportType, Double price, String username, LocalDate date,String pista,int inicio,int fin) {
        this.id = id;
        this.image = image;
        this.price = price;
        this.sportType = sportType;
        this.username = username;
        this.pista = new Pista(pista);
        this.inicio = inicio;
        this.fin = fin;
        this.date = date;
    }

    @Override
    public String toString() {
        return username+"\t"+price+" €\t"+date.toString();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public Pista getPista() {
        return pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
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
}
