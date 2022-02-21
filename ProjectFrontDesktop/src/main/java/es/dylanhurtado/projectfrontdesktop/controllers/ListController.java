package es.dylanhurtado.projectfrontdesktop.controllers;

import es.dylanhurtado.projectfrontdesktop.model.Pista;
import es.dylanhurtado.projectfrontdesktop.model.Reserva;
import es.dylanhurtado.projectfrontdesktop.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

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

    @FXML private StackPane pista;
    @FXML private StackPane reserva;
    @FXML private StackPane user;

    @FXML private Button homeButton;
    @FXML private Button editButton;
    @FXML private Button deleteButton;
    @FXML private Button addButton;
    @FXML private Button saveButton;

    private ObservableList<Object> pistaObservableList;
    private ObservableList<Object> reservaObservableList;
    private ObservableList<Object> usuariosObservableList;

    private boolean pistasRef = false;
    private boolean reservasRef = false;
    private boolean usuariosRef = false;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showHome();
        pistaObservableList = FXCollections.observableArrayList();
        reservaObservableList = FXCollections.observableArrayList();
        usuariosObservableList = FXCollections.observableArrayList();
        pistaObservableList.addAll(new Pista(1L, "fsdf", "fdsf", 123d, "dfsd"),new Pista(2L, "fsdf", "fdsf", 123d, "dfsd"),new Pista(3L, "fsdf", "fdsf", 123d, "dfsd"));
        listView.setItems(pistaObservableList);
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (reservasRef) {
                    reservaController.setReservaSelected((Reserva) listView.getSelectionModel().getSelectedItem());
                    showPreview(reserva);
                } else if (pistasRef) {
                    pistaController.setPistaSelected(listView.getSelectionModel().getSelectedItem());
                    showPreview(pista);
                } else if (usuariosRef) {
                    userController.setUsuarioSelected((User) listView.getSelectionModel().getSelectedItem());
                    showPreview(user);
                }
            }
        });

    }

    public boolean isPistasRef() {
        return pistasRef;
    }

    public void setPistasRef(boolean pistasRef) {
        this.pistasRef = pistasRef;
    }

    public boolean isReservasRef() {
        return reservasRef;
    }

    public void setReservasRef(boolean reservasRef) {
        this.reservasRef = reservasRef;
    }

    public boolean isUsuariosRef() {
        return usuariosRef;
    }

    public void setUsuariosRef(boolean usuariosRef) {
        this.usuariosRef = usuariosRef;
    }

    public StackPane getPista() {
        return pista;
    }

    public void setPista(StackPane pista) {
        this.pista = pista;
    }

    public StackPane getReserva() {
        return reserva;
    }

    public void setReserva(StackPane reserva) {
        this.reserva = reserva;
    }

    public StackPane getUser() {
        return user;
    }

    public void setUser(StackPane user) {
        this.user = user;
    }

    public Button getHomeButton() {
        return homeButton;
    }

    private void showPreview(StackPane item){
        item.setTranslateX(0);
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


    @FXML
    private void showHome(){
        setPistasRef(false);
        setReservasRef(false);
        setUsuariosRef(false);
        list.setTranslateY(3000);
        getPista().setTranslateX(3000);
        getReserva().setTranslateX(3000);
        getUser().setTranslateX(3000);
        homeButton.setDisable(true);
        homeButton.setVisible(false);
        editButton.setDisable(true);
        editButton.setVisible(false);
        deleteButton.setDisable(true);
        deleteButton.setVisible(false);
        saveButton.setDisable(true);
        saveButton.setVisible(false);

    }
}

