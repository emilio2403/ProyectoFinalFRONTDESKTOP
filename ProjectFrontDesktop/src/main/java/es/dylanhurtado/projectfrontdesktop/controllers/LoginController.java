package es.dylanhurtado.projectfrontdesktop.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class LoginController {

    @FXML
    private TextField emailTextField;

    @FXML
    private HBox hbox;

    @FXML
    private ImageView image;

    @FXML
    private StackPane imageWrapper;

    @FXML
    private StackPane login;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordTextField;

    @FXML
    private VBox vboxInputs;

    @FXML
    private void login(){
        login.setTranslateY(-3000);
    }
}
