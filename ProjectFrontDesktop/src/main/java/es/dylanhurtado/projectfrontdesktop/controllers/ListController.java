package es.dylanhurtado.projectfrontdesktop.controllers;

import es.dylanhurtado.projectfrontdesktop.model.Pista;
import es.dylanhurtado.projectfrontdesktop.model.Reserva;
import es.dylanhurtado.projectfrontdesktop.model.User;
import es.dylanhurtado.projectfrontdesktop.rest.Config;
import es.dylanhurtado.projectfrontdesktop.rest.RestOperations;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import retrofit2.Response;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

public class ListController implements Initializable {

    @FXML
    private StackPane list;

    @FXML
    private ListView listView;

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

    private ObservableList<Pista> pistaObservableList;
    private ObservableList<Reserva> reservaObservableList;
    private ObservableList<User> usuariosObservableList;

    private boolean pistasRef = false;
    private boolean reservasRef = false;
    private boolean usuariosRef = false;

    private TranslateTransition animation;

    private String sportType;

    private RestOperations restOperations;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showHome();
        restOperations= Config.getService();
        pistaObservableList = FXCollections.observableArrayList();
        reservaObservableList = FXCollections.observableArrayList();
        usuariosObservableList = FXCollections.observableArrayList();
        pistaObservableList.addAll(new Pista(UUID.randomUUID(), "fsdf", "fdsf", 123d, "dfsd",1,1), new Pista(UUID.randomUUID(), "fsdf", "fdsf", 123d, "dfsd",1,1), new Pista(UUID.randomUUID(), "fsdf", "fdsf", 123d, "dfsd",1,1));
        reservaObservableList.addAll(new Reserva(UUID.randomUUID(), "fsdf", "fdsf", 222d, "dfsd", LocalDate.now(), "dsf",1,1), new Reserva(UUID.randomUUID(), "fsdf", "fdsf", 222d, "dfsd", LocalDate.now(), "sdkfjs",1,1), new Reserva(UUID.randomUUID(), "fsdf", "fdsf", 222d, "dfsd", LocalDate.now(), "sifdfj",1,1));
        usuariosObservableList.addAll(new User(UUID.randomUUID(), "", "", "", ""), new User(UUID.randomUUID(), "", "", "", ""), new User(UUID.randomUUID(), "", "", "", ""));
        listView.setItems(FXCollections.observableArrayList((Object) pistaObservableList));

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (reservasRef) {
                    reservaController.setReservaSelected((Reserva) listView.getSelectionModel().getSelectedItem());
                    setTextFieldsReserva();
                    onActionReservaEdit();
                    onActionReservaDelete();
                    showPreview(reserva);
                } else if (pistasRef) {
                    pistaController.setPistaSelected((Pista) listView.getSelectionModel().getSelectedItem());
                    setTextFieldsPista();
                    onActonEditPista();
                    onActionPistaDelete();
                    showPreview(pista);
                } else if (usuariosRef) {
                    userController.setUsuarioSelected((User) listView.getSelectionModel().getSelectedItem());
                    setTextFieldsUser();
                    onActionUserEdit();
                    onActionUserDelete();
                    showPreview(user);
                }
            }
        });
    }

    private void setTextFieldsReserva() {
        reservaController.getPriceTextField().setText(reservaController.getSelectedItem().getPrice().toString());
        reservaController.getPistaTextField().setText(reservaController.getSelectedItem().getPista().getTitle());
        reservaController.getClientNameTextField().setText(reservaController.getSelectedItem().getUsername());
        reservaController.getDateField().setValue(reservaController.getSelectedItem().getDate());
        reservaController.getInicioTextField().setText(String.valueOf(reservaController.getSelectedItem().getInicio()));
        reservaController.getFinTextField().setText(String.valueOf(reservaController.getSelectedItem().getFin()));
        reservaController.blockTextFields();
    }

    private void onActionReservaEdit() {
        editButton.setOnAction(actionEvent -> {
            reservaController.unlockTextFields();
            editButton.setVisible(false);
            saveButton.setVisible(true);
            saveButton.setOnAction(actionEvent1 -> {
                reservaController.getSelectedItem().setPrice(Double.valueOf(reservaController.getPriceTextField().getText()));
                reservaController.getSelectedItem().setUsername(reservaController.getClientNameTextField().getText());
                reservaController.getSelectedItem().setDate(reservaController.getDateField().getValue());
                reservaController.getSelectedItem().setPista(new Pista(reservaController.getPistaTextField().getText()));
                reservaController.getSelectedItem().setInicio(Integer.parseInt(reservaController.getInicioTextField().getText()));
                reservaController.getSelectedItem().setFin(Integer.parseInt(reservaController.getFinTextField().getText()));
                editButton.setVisible(true);
                reservaController.blockTextFields();
                saveButton.setVisible(false);
            });
        });
    }

    private void onActionReservaDelete() {
        deleteButton.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Are you sure ?");
            alert.setHeaderText("Estas a punto de borrar una reserva");
            alert.setContentText("Estas seguro/a ?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                showHome();
                reservaObservableList.remove(reservaController.getSelectedItem());
            }
        });
    }

    public void onActionReservaAdd() {
        addButton.setOnAction(actionEvent -> {
            showPreview(reserva);
            reservaController.unlockTextFields();
            editButton.setVisible(false);
            deleteButton.setVisible(false);
            saveButton.setVisible(true);
            saveButton.setOnAction(actionEvent1 -> {
                reservaObservableList.add(new Reserva(UUID.randomUUID(),
                        "",
                        reservaController.getSportTypeSelector().getValue(),
                        Double.valueOf(reservaController.getPriceTextField().getText()),
                        reservaController.getClientNameTextField().getText(),
                        reservaController.getDateField().getValue(),
                        reservaController.getPistaTextField().getText(),
                        Integer.parseInt(reservaController.getInicioTextField().getText()),
                        Integer.parseInt(reservaController.getFinTextField().getText())));

                editButton.setVisible(true);
                deleteButton.setVisible(true);
                reservaController.blockTextFields();
                saveButton.setVisible(false);
                showHome();
            });
        });
    }

    private void setTextFieldsPista() {
        pistaController.getTitleTextField().setText(pistaController.getSelectedItem().getTitle());
        pistaController.getPriceTextField().setText(pistaController.getSelectedItem().getPrice().toString());
        pistaController.getDescriptionTextField().setText(pistaController.getSelectedItem().getDescription());
        pistaController.getAperturaField().setText(String.valueOf(pistaController.getSelectedItem().getApertura()));
        pistaController.getCierreTextField().setText(String.valueOf(pistaController.getSelectedItem().getCierre()));
        pistaController.blockTextFields();
    }

    private void onActonEditPista() {
        editButton.setOnAction(actionEvent -> {
            pistaController.unlockTextFields();
            editButton.setVisible(false);
            saveButton.setVisible(true);
            saveButton.setOnAction(actionEvent1 -> {
                pistaController.getSelectedItem().setTitle(pistaController.getTitleTextField().getText());
                pistaController.getSelectedItem().setPrice(Double.valueOf(pistaController.getPriceTextField().getText()));
                pistaController.getSelectedItem().setDescription(pistaController.getDescriptionTextField().getText());
                editButton.setVisible(true);
                pistaController.blockTextFields();
                saveButton.setVisible(false);
            });
        });
    }

    private void onActionPistaDelete() {
        deleteButton.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Are you sure ?");
            alert.setHeaderText("Estas a punto de borrar una pista");
            alert.setContentText("Estas seguro/a ?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                try {
                    Response response=restOperations.infraestructuraDelete(pistaController.getSelectedItem().getId()).execute();
                    if(response.isSuccessful()&&response.code()==204){
                        showHome();
                        pistaObservableList.remove(pistaController.getSelectedItem());
                    }else{
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("Error 404");
                        alert1.setHeaderText("Llamada a la api fallida al cargar las reservas");
                        alert1.show();
                    }
                } catch (IOException e) {
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Error 404");
                    alert2.setHeaderText("Llamada a la api fallida al cargar las reservas");
                    alert2.show();
                }
            }
        });
    }

    public void onActionPistaAdd() {
        addButton.setOnAction(actionEvent -> {
            showPreview(pista);
            pistaController.unlockTextFields();
            editButton.setVisible(false);
            deleteButton.setVisible(false);
            saveButton.setVisible(true);
            saveButton.setOnAction(actionEvent1 -> {
                pistaObservableList.add(new Pista(UUID.randomUUID(),
                        "",
                        pistaController.getTitleTextField().getText(),
                        Double.valueOf(pistaController.getPriceTextField().getText()),
                        pistaController.getDescriptionTextField().getText(),
                        Integer.parseInt(pistaController.getAperturaField().getText()),
                        Integer.parseInt(pistaController.getCierreTextField().getText())));

                editButton.setVisible(true);
                deleteButton.setVisible(true);
                pistaController.blockTextFields();
                saveButton.setVisible(false);
                showHome();
            });
        });
    }

    private void setTextFieldsUser() {
        userController.getUserTextField().setText(userController.getSelectedItem().getUsername());
        userController.getEmailTextField().setText(userController.getSelectedItem().getEmail());
        userController.getDescriptionTextArea().setText(userController.getSelectedItem().getDescription());
        userController.blockTextFields();
    }

    private void onActionUserEdit() {
        editButton.setOnAction(actionEvent -> {
            userController.unlockTextFields();
            editButton.setVisible(false);
            saveButton.setVisible(true);
            saveButton.setOnAction(actionEvent1 -> {
                userController.getSelectedItem().setUsername(userController.getUserTextField().getText());
                userController.getSelectedItem().setEmail(userController.getEmailTextField().getText());
                userController.getSelectedItem().setDescription(userController.getDescriptionTextArea().getText());
                editButton.setVisible(true);
                pistaController.blockTextFields();
                saveButton.setVisible(false);
            });
        });
    }

    private void onActionUserDelete() {
        deleteButton.setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Are you sure ?");
            alert.setHeaderText("Estas a punto de borrar un usuario");
            alert.setContentText("Estas seguro/a ?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {

                showHome();
                usuariosObservableList.remove(userController.getSelectedItem());
            }
        });
    }

    public void onActionUserAdd() {
        addButton.setOnAction(actionEvent -> {
            showPreview(user);
            userController.unlockTextFields();
            editButton.setVisible(false);
            deleteButton.setVisible(false);
            saveButton.setVisible(true);
            saveButton.setOnAction(actionEvent1 -> {
                usuariosObservableList.add(new User(UUID.randomUUID(),
                        "",
                        userController.getUserTextField().getText(),
                        userController.getEmailTextField().getText(),
                        userController.getDescriptionTextArea().getText()));

                editButton.setVisible(true);
                deleteButton.setVisible(true);
                userController.blockTextFields();
                saveButton.setVisible(false);
                showHome();
            });
        });
    }

    private void showPreview(StackPane item) {
        animation = new TranslateTransition(Duration.millis(600), item);
        animation.setFromX(3000);
        animation.setToX(0);
        animation.play();
        deleteButton.setVisible(true);
        addButton.setVisible(false);
        editButton.setVisible(true);
        deleteButton.setVisible(true);
        saveButton.setVisible(false);
    }

    private void hidePreview(StackPane item) {
        animation = new TranslateTransition(Duration.millis(600), item);
        animation.setFromX(0);
        animation.setToX(3000);
        animation.play();
    }


    @FXML
    public void showHome() {
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
        homeButton.setVisible(false);
        editButton.setVisible(false);
        deleteButton.setVisible(false);
        saveButton.setVisible(false);
        reservaController.clearTextFields();
        pistaController.clearTextFields();
        userController.clearTextFields();
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

    public void addReservastoList(List<Reserva> reservas){
        reservaObservableList.clear();
        reservaObservableList.addAll(reservas);
        listView.setItems(reservaObservableList);
    }
    public void addPistastoList(List<Pista> pistas){
        pistaObservableList.clear();
        pistaObservableList.addAll(pistas);
        listView.setItems(pistaObservableList);
    }
    public void addUserstoList(List<User> users){
        usuariosObservableList.clear();
        usuariosObservableList.addAll(users);
        listView.setItems(usuariosObservableList);
    }

    public ListView<Object> getListView() {
        return listView;
    }

    public ObservableList<Pista> getPistaObservableList() {
        return pistaObservableList;
    }

    public ObservableList<Reserva> getReservaObservableList() {
        return reservaObservableList;
    }

    public ObservableList<User> getUsuariosObservableList() {
        return usuariosObservableList;
    }

    public Button getHomeButton() {
        return homeButton;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public Label getTypeLabel() {
        return typeLabel;
    }

    public String getSportType() {
        return sportType;
    }

    public Button getAddButton() {
        return addButton;
    }
}

