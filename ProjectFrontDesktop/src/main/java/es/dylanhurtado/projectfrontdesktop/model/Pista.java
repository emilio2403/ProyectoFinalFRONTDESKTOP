package es.dylanhurtado.projectfrontdesktop.model;

public class Pista {
    private Long id;
    private String image;
    private String title;
    private Double price;
    private String description;

    public Pista() {
    }

    public Pista(Long id, String image, String title, Double price, String description) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
