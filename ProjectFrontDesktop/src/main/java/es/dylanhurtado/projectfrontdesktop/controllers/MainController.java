package es.dylanhurtado.projectfrontdesktop.controllers;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Button baloncesto;


    @FXML
    private Button buttonLogout;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button addButton;

    @FXML
    private Button futbol;


    @FXML
    private Button padel;

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
    private Button rugby;

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
    private Button tenis;

    @FXML
    private FontIcon userIcon;

    @FXML
    private VBox vboxWrapperMain;

    @FXML
    private Button volleyball;

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
        hideMainButtons();
    }

    @FXML
    private void logOut() {
        loginAnimation = new TranslateTransition(Duration.millis(600), login);
        loginAnimation.setFromY(-3000);
        loginAnimation.setToY(0);
        loginAnimation.play();
        list.setVisible(false);
        hideMainButtons();
    }

    @FXML
    private void showListReservas() {
        listController.getListView().setItems(mapToObject(listController.getReservaObservableList()));
        listController.setReservasRef(true);
        listController.getTypeLabel().setText("Reservas");
        listController.onActionReservaAdd();
        showList();
    }

    @FXML
    private void showListPistas() {
        listController.getListView().setItems(mapToObject(listController.getPistaObservableList()));
        listController.setPistasRef(true);
        listController.getTypeLabel().setText("Pistas");
        listController.onActionPistaAdd();
        showList();
    }

    @FXML
    private void showListUsuarios() {
        listController.getListView().setItems(mapToObject(listController.getUsuariosObservableList()));
        listController.setUsuariosRef(true);
        listController.getTypeLabel().setText("Usuarios");
        listController.onActionUserAdd();
        showList();
    }

    private ObservableList<Object> mapToObject(ObservableList o) {
        ObservableList<Object> observableList = FXCollections.observableArrayList();
        observableList.addAll(o);
        return observableList;
    }

    private void showList() {
        list.setVisible(true);
        listAnimation = new TranslateTransition(Duration.millis(600), list);
        listAnimation.setFromY(3000);
        listAnimation.setToY(0);
        listAnimation.play();
        listController.getHomeButton().setVisible(true);
        listController.getAddButton().setVisible(true);
    }

    private void hideMainButtons() {
        hboxPistas.setVisible(false);
        hboxReservas.setVisible(false);
    }

    @FXML
    private void sportSelected() {
        hboxPistas.setVisible(true);
        hboxReservas.setVisible(true);
        if (tenis.isFocused()) {
            listController.setSportType("tenis");
        } else if (baloncesto.isFocused()) {
            listController.setSportType("baloncesto");
        } else if (padel.isFocused()) {
            listController.setSportType("padel");
        } else if (futbol.isFocused()) {
            listController.setSportType("futbol");
        } else if (rugby.isFocused()) {
            listController.setSportType("rugby");
        } else {
            listController.setSportType("volleyball");
        }
    }

}

