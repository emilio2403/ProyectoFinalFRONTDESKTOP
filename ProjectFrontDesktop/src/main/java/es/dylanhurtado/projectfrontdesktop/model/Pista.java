package es.dylanhurtado.projectfrontdesktop.model;

import java.util.UUID;

public class Pista {
    private UUID id;
    private String image;
    private String title;
    private Double price;
    private String description;
    private int apertura;
    private int cierre;

    public Pista() {
    }

    public Pista(UUID id, String image, String title, Double price, String description,int apertura, int cierre) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.price = price;
        this.description = description;
        this.apertura = apertura;
        this.cierre = cierre;
    }

    public Pista(String title) {
        this.title=title;
    }

    @Override
    public String toString() {
        return title +"\t"+ price + "\t"+description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
