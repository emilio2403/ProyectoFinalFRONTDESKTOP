package es.dylanhurtado.projectfrontdesktop.controllers;

import es.dylanhurtado.projectfrontdesktop.dto.AlquilerDTO;
import es.dylanhurtado.projectfrontdesktop.dto.ClienteDTO;
import es.dylanhurtado.projectfrontdesktop.dto.InfraestructuraDTO;
import es.dylanhurtado.projectfrontdesktop.mapper.Mapper;
import es.dylanhurtado.projectfrontdesktop.rest.Config;
import es.dylanhurtado.projectfrontdesktop.rest.RestOperations;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
import retrofit2.Response;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private StackPane grafico;
    @FXML
    private GraficoController graficoController;
    @FXML
    private Label adminNameLabel;

    @FXML
    private HBox adminWrapper;

    @FXML
    private HBox messageWrapper;

    @FXML Label messageLabel;
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
    private VBox vboxPistas;

    @FXML
    private VBox vboxReservas;

    @FXML
    private VBox vboxGraficos;


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

    @FXML
    private LoginController loginController;

    private Mapper mapper;

    private TranslateTransition loginAnimation, listAnimation;
    private RestOperations restOperations;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mapper=new Mapper();
        restOperations = Config.getService();
        messageWrapper.setVisible(true);
        graficoController.hideVistaGraficos();
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
        graficoController.hideVistaGraficos();
        loginController.getEmailTextField().clear();
        loginController.getPasswordTextField().clear();
    }

    @FXML
    private void showListReservas() throws IOException {
        listController.getListView().setItems(mapToObject(listController.getReservaObservableList()));
        listController.setReservasRef(true);
        listController.getTypeLabel().setText("Reservas");
        listController.onActionReservaAdd();
        showList();

    }
    private void getInfraestructuraTipo() throws IOException {
        Response<List<InfraestructuraDTO>> infraestructuraResponse = restOperations.infraestructuraByTipo(listController.getSportType()).execute();
        if (infraestructuraResponse.isSuccessful() && infraestructuraResponse.code() == 200) {
            List<InfraestructuraDTO> infraestructurasDTO = infraestructuraResponse.body();
            listController.addReservastoList(mapper.toReserva(infraestructurasDTO));
            listController.addPistastoList(mapper.toPista(infraestructurasDTO));
            listController.setInfraestructuraDTOS(infraestructurasDTO);
            List<AlquilerDTO> alquileres=new ArrayList();
            infraestructurasDTO.forEach(i->i.getAlquileres().forEach(a->alquileres.add(a)));
            listController.setAlquileresDTOS(alquileres);
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error 404");
            alert.setHeaderText("Llamada a la api fallida al cargar las reservas");
            alert.show();
        }
    }

    @FXML
    private void showListPistas() throws IOException {
        listController.getListView().setItems(mapToObject(listController.getPistaObservableList()));
        listController.setPistasRef(true);
        listController.getTypeLabel().setText("Pistas");
        listController.onActionPistaAdd();
        showList();
    }

    @FXML
    private void showListUsuarios() throws IOException {
        listController.getListView().setItems(mapToObject(listController.getUsuariosObservableList()));
        listController.setUsuariosRef(true);
        listController.getTypeLabel().setText("Usuarios");
        listController.onActionUserAdd();
        showList();
        getUsersAPI();
    }

    private void getUsersAPI() throws IOException {
        Response<List<ClienteDTO>> clientResponse = restOperations.getClientes().execute();
        if (clientResponse.isSuccessful() && clientResponse.code() == 200) {
            List<ClienteDTO> clientes = clientResponse.body();
            listController.addUserstoList(mapper.toUser(clientes));
            listController.setClienteDTOS(clientes);
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error 404");
            alert.setHeaderText("Llamada a la api fallida al cargar las reservas");
            alert.show();
        }
    }

    @FXML
    private void showGraficos() {
        TranslateTransition animation = new TranslateTransition(Duration.millis(600), grafico);
        animation.setFromX(3000);
        animation.setToX(0);
        animation.play();
        conteoParaGrafico();
        graficoController.loadGraficoCircular();
        graficoController.loadGraficoBarras();
    }

    private void conteoParaGrafico() {
        int totalPrecio=0;
        List<InfraestructuraDTO> listPista = listController.getInfraestructuraDTOS();
        List<Integer> porcentajes = new ArrayList<>();
        List<Integer> ganancias = new ArrayList<>();
        for (int i = 0; i < listPista.size(); i++) {
            porcentajes.add(listPista.get(i).getAlquileres().size());
            totalPrecio += listPista.get(i).getAlquileres().stream().mapToInt(x -> (int) x.getCoste()).sum();
            ganancias.add(totalPrecio);
        }

        graficoController.setPorcentajesCircular(porcentajes);
        graficoController.setDatosGraficosBarras(ganancias);
    }

    private ObservableList<Object> mapToObject(ObservableList list) {
        ObservableList<Object> observableList = FXCollections.observableArrayList();
        observableList.addAll(list);
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
        vboxPistas.setVisible(false);
        vboxReservas.setVisible(false);
        vboxGraficos.setVisible(false);
        messageWrapper.setVisible(true);
    }

    @FXML
    private void sportSelected() throws IOException {
        messageWrapper.setVisible(false);
        vboxPistas.setVisible(true);
        vboxReservas.setVisible(true);
        vboxGraficos.setVisible(true);
        if (tenis.isFocused()) {
            listController.setSportType("TENIS");
        } else if (baloncesto.isFocused()) {
            listController.setSportType("BALONCESTO");
        } else if (padel.isFocused()) {
            listController.setSportType("PADEL");
        } else if (futbol.isFocused()) {
            listController.setSportType("FUTBOL");
        } else if (rugby.isFocused()) {
            listController.setSportType("RUGBY");
        } else {
            listController.setSportType("VOLEY");
        }
        getInfraestructuraTipo();
    }

}

