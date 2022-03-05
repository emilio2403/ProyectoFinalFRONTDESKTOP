package es.dylanhurtado.projectfrontdesktop.model;

import java.time.LocalDate;
import java.util.UUID;

public class Reserva {
    private UUID id;
    private String image;
    private String title;
    private Double price;
    private String username;
    private LocalDate date;
    private String description;

    public Reserva() {
    }

    public Reserva(UUID id, String image, String title, Double price, String username, LocalDate date, String description) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.price = price;
        this.username = username;
        this.description = description;
        this.date = date;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
