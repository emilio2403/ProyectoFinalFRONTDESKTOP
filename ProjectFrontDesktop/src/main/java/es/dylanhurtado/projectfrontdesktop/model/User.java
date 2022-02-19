package es.dylanhurtado.projectfrontdesktop.model;

public class User {
    private Long id;
    private String image;
    private String username;
    private String email;

    public User() {
    }

    public User(Long id, String image, String username, String email) {
        this.id = id;
        this.image = image;
        this.username = username;
        this.email = email;
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
