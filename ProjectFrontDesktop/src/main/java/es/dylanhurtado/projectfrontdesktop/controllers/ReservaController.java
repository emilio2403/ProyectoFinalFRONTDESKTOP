package es.dylanhurtado.projectfrontdesktop.controllers;
import es.dylanhurtado.projectfrontdesktop.model.Reserva;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ReservaController {

    @FXML
    private TextField clientNameTextField;

    @FXML
    private Label dayAndHourLabel;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private HBox hboxReserva;

    @FXML
    private ImageView imageReserva;

    @FXML
    private StackPane imageWrapper;

    @FXML
    private TextField priceTextField;

    @FXML
    private StackPane reserva;

    @FXML
    private TextField titleTextField;

    @FXML
    private VBox vboxForm;

    private Reserva selectedItem;
    public void setReservaSelected(Reserva selectedItem) {
        this.selectedItem=selectedItem;

    }
}