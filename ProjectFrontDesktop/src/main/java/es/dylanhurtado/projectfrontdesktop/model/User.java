package es.dylanhurtado.projectfrontdesktop.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String image;
    private String username;
    private String email;
    private String description;

    public User() {
    }

    public User(UUID id, String image, String username, String email, String description) {
        this.id = id;
        this.image = image;
        this.username = username;
        this.email = email;
        this.description = description;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
