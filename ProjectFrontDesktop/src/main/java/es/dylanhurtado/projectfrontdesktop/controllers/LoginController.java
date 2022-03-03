package es.dylanhurtado.projectfrontdesktop.controllers;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class LoginController {

    @FXML
    private TextField emailTextField;
    @FXML
    private HBox hbox;
    @FXML
    private ImageView image;
    @FXML
    private StackPane login;
    @FXML
    private Button loginButton;
    @FXML
    private ImageView imageLoginBackground;
    @FXML
    private TextField passwordTextField;
    @FXML
    private VBox vboxInputs;
    private TranslateTransition loginAnimation;

    @FXML
    private void login() {
        loginAnimation = new TranslateTransition(Duration.millis(600), login);
        loginAnimation.setFromY(0);
        loginAnimation.setToY(-3000);
        loginAnimation.play();
    }
}
