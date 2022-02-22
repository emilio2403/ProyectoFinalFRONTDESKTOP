package es.dylanhurtado.projectfrontdesktop.controllers;

import javafx.animation.TranslateTransition;
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
import javafx.util.Duration;
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

    @FXML
    private StackPane login;
    @FXML
    private StackPane list;

    @FXML
    private ListController listController;

    private TranslateTransition loginAnimation, listAnimation;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void logOut() {
        loginAnimation = new TranslateTransition(Duration.millis(600), login);
        loginAnimation.setFromY(-3000);
        loginAnimation.setToY(0);
        loginAnimation.play();

    }

    @FXML
    private void showListReservas() {
        listController.getListView().setItems(listController.getReservaObservableList());
        listController.setReservasRef(true);
        showList();

    }

    @FXML
    private void showListPistas() {
        listController.getListView().setItems(listController.getPistaObservableList());
        listController.setPistasRef(true);
        showList();
    }

    @FXML
    private void showListUsuarios() {
        listController.getListView().setItems(listController.getUsuariosObservableList());
        listController.setUsuariosRef(true);
        showList();
    }

    private void showList() {
        listAnimation = new TranslateTransition(Duration.millis(600), list);
        listAnimation.setFromY(3000);
        listAnimation.setToY(0);
        listAnimation.play();
        listController.getHomeButton().setDisable(false);
        listController.getHomeButton().setVisible(true);
    }


}

