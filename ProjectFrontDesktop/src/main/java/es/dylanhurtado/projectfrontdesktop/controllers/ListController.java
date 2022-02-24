package es.dylanhurtado.projectfrontdesktop.controllers;

import es.dylanhurtado.projectfrontdesktop.model.Pista;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ListController implements Initializable {

    @FXML
    private StackPane list;

    @FXML
    private ListView<Object> listView;

    @FXML
    private Label typeLabel;

    @FXML
    private VBox vbox;

    @FXML
    private MainController mainController;
    @FXML
    private PistaController pistaController;
    @FXML
    private ReservaController reservaController;
    @FXML
    private UserController userController;

    @FXML
    private StackPane pista;
    @FXML
    private StackPane reserva;
    @FXML
    private StackPane user;

    @FXML
    private Button homeButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;
    @FXML
    private Button saveButton;

    private ObservableList<Object> pistaObservableList;
    private ObservableList<Object> reservaObservableList;
    private ObservableList<Object> usuariosObservableList;

    private boolean pistasRef = false;
    private boolean reservasRef = false;
    private boolean usuariosRef = false;

    private TranslateTransition animation;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showHome();
        pistaObservableList = FXCollections.observableArrayList();
        reservaObservableList = FXCollections.observableArrayList();
        usuariosObservableList = FXCollections.observableArrayList();
        pistaObservableList.addAll(new Pista(1L, "fsdf", "fdsf", 123d, "dfsd"), new Pista(2L, "fsdf", "fdsf", 123d, "dfsd"), new Pista(3L, "fsdf", "fdsf", 123d, "dfsd"));
        listView.setItems(pistaObservableList);

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (reservasRef) {
                    reservaController.setReservaSelected(listView.getSelectionModel().getSelectedItem());
                    showPreview(reserva);
                } else if (pistasRef) {
                    pistaController.setPistaSelected(listView.getSelectionModel().getSelectedItem());
                    showPreview(pista);
                } else if (usuariosRef) {
                    userController.setUsuarioSelected(listView.getSelectionModel().getSelectedItem());
                    showPreview(user);
                }
            }
        });
    }

    private void showPreview(StackPane item) {
        animation = new TranslateTransition(Duration.millis(600), item);
        animation.setFromX(3000);
        animation.setToX(0);
        animation.play();
        deleteButton.setDisable(false);
        deleteButton.setVisible(true);
        addButton.setDisable(true);
        addButton.setVisible(false);
        editButton.setDisable(false);
        editButton.setVisible(true);
        deleteButton.setDisable(false);
        deleteButton.setVisible(true);
        saveButton.setDisable(true);
        saveButton.setVisible(false);
    }

    private void hidePreview(StackPane item) {
        animation = new TranslateTransition(Duration.millis(600), item);
        animation.setFromX(0);
        animation.setToX(3000);
        animation.play();
    }


    @FXML
    private void showHome() {
        setPistasRef(false);
        setReservasRef(false);
        setUsuariosRef(false);
        hidePreview(pista);
        hidePreview(reserva);
        hidePreview(user);
        animation = new TranslateTransition(Duration.millis(600), list);
        animation.setFromY(0);
        animation.setToY(3000);
        animation.play();
        homeButton.setDisable(true);
        homeButton.setVisible(false);
        editButton.setDisable(true);
        editButton.setVisible(false);
        deleteButton.setDisable(true);
        deleteButton.setVisible(false);
        saveButton.setDisable(true);
        saveButton.setVisible(false);
    }

    public void setPistasRef(boolean pistasRef) {
        this.pistasRef = pistasRef;
    }

    public void setReservasRef(boolean reservasRef) {
        this.reservasRef = reservasRef;
    }

    public void setUsuariosRef(boolean usuariosRef) {
        this.usuariosRef = usuariosRef;
    }


    public ListView<Object> getListView() {
        return listView;
    }

    public ObservableList<Object> getPistaObservableList() {
        return pistaObservableList;
    }

    public ObservableList<Object> getReservaObservableList() {
        return reservaObservableList;
    }

    public ObservableList<Object> getUsuariosObservableList() {
        return usuariosObservableList;
    }

    public Button getHomeButton() {
        return homeButton;
    }
}

