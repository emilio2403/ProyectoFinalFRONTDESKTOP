package es.dylanhurtado.projectfrontdesktop.controllers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Label adminNameLabel;

    @FXML
    private HBox adminWrapper;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private VBox baloncesto;

    @FXML
    private FontIcon baloncestoIcon;

    @FXML
    private Button buttonLogout;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button addButton;

    @FXML
    private VBox futbol;

    @FXML
    private FontIcon futbolIcon;

    @FXML
    private VBox futbolSala;

    @FXML
    private FontIcon futbolSalaIcon;

    @FXML
    private HBox hboxDeleteEdit;

    @FXML
    private HBox hboxPistas;

    @FXML
    private HBox hboxReservas;

    @FXML
    private HBox hboxToolbar;

    @FXML
    private HBox hboxUsers;

    @FXML
    private HBox hboxView;

    @FXML
    private Button homeButton;

    @FXML
    private FontIcon iconLogout;

    @FXML
    private FontIcon iconPista;

    @FXML
    private ImageView image;

    @FXML
    private StackPane imageWrapper;

    @FXML
    private StackPane main;

    @FXML
    private VBox padel;

    @FXML
    private FontIcon padelIcon;

    @FXML
    private Label pistaLabel;

    @FXML
    private FontIcon reservasIcon;

    @FXML
    private Label reservasLabel;

    @FXML
    private Button saveButton;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private StackPane stackPaneView;

    @FXML
    private VBox tenis;

    @FXML
    private FontIcon userIcon;

    @FXML
    private VBox vboxWrapperMain;

    @FXML
    private VBox volleyball;

    @FXML
    private FontIcon volleyballIcon;

    @FXML private StackPane login;
    @FXML private StackPane list;
    @FXML private StackPane pista;
    @FXML private StackPane reserva;
    @FXML private StackPane user;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showHome();
    }
    @FXML
    private void logOut(){
        login.setTranslateY(0);

    }
    @FXML
    private void showListReservas(){
        showList(list);

    }
    @FXML
    private void showListPistas(){
        showList(list);
    }

    @FXML
    private void showPista(){
        showPreview(pista);
    }

    private void showPreview(StackPane item) {
        item.setTranslateX(0);
        homeButton.setDisable(false);
        homeButton.setVisible(true);
        editButton.setDisable(false);
        editButton.setVisible(true);
        deleteButton.setDisable(false);
        deleteButton.setVisible(true);
        addButton.setDisable(true);
        addButton.setVisible(false);
        saveButton.setDisable(true);
        saveButton.setVisible(false);
    }

    private void showList(StackPane item) {
        item.setTranslateY(0);
        homeButton.setDisable(false);
        homeButton.setVisible(true);
        editButton.setDisable(true);
        editButton.setVisible(false);
        deleteButton.setDisable(true);
        deleteButton.setVisible(false);
        addButton.setDisable(false);
        addButton.setVisible(true);
        saveButton.setDisable(true);
        saveButton.setVisible(false);
    }

    @FXML
    private void showReserva(){
        showPreview(reserva);
    }

    @FXML
    private void showUsuario(){
        showPreview(user);
    }

    @FXML
    private void showHome(){
        list.setTranslateY(3000);
        pista.setTranslateX(3000);
        reserva.setTranslateX(3000);
        user.setTranslateX(3000);
        homeButton.setDisable(true);
        homeButton.setVisible(false);
        editButton.setDisable(true);
        editButton.setVisible(false);
        deleteButton.setDisable(true);
        deleteButton.setVisible(false);
        addButton.setDisable(true);
        addButton.setVisible(false);
        saveButton.setDisable(true);
        saveButton.setVisible(false);
    }


}

