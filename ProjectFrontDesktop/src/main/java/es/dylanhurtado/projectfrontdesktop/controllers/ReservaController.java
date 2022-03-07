package es.dylanhurtado.projectfrontdesktop.controllers;

import es.dylanhurtado.projectfrontdesktop.model.Reserva;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ReservaController implements Initializable {

    @FXML
    private TextField clientNameTextField;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField pistaTextField;

    @FXML
    private TextField inicioTextField;

    @FXML
    private TextField finTextField;



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
    private ChoiceBox<String> sportTypeSelector;

    @FXML
    private VBox vboxForm;

    private Reserva selectedItem;

    public void setReservaSelected(Reserva selectedItem) {
        this.selectedItem = selectedItem;
    }

    public Reserva getSelectedItem() {
        return selectedItem;
    }

    public void blockTextFields() {
        priceTextField.setEditable(false);
        clientNameTextField.setEditable(false);
        pistaTextField.setEditable(false);
        inicioTextField.setEditable(false);
        finTextField.setEditable(false);
        dateField.setEditable(false);

    }

    public void unlockTextFields() {
        clientNameTextField.setEditable(false);
        pistaTextField.setEditable(false);
        priceTextField.setEditable(true);
        inicioTextField.setEditable(true);
        finTextField.setEditable(true);
        dateField.setEditable(true);
    }

    public void clearTextFields() {
        priceTextField.clear();
        clientNameTextField.clear();
        pistaTextField.clear();
        inicioTextField.clear();
        finTextField.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        blockTextFields();
    }


    public TextField getClientNameTextField() {
        return clientNameTextField;
    }

    public void setClientNameTextField(TextField clientNameTextField) {
        this.clientNameTextField = clientNameTextField;
    }

    public TextField getPriceTextField() {
        return priceTextField;
    }

    public void setPriceTextField(TextField priceTextField) {
        this.priceTextField = priceTextField;
    }

    public ChoiceBox<String> getSportTypeSelector() {
        return sportTypeSelector;
    }

    public void setSportTypeSelector(ChoiceBox<String> sportTypeSelector) {
        this.sportTypeSelector = sportTypeSelector;
    }

    public DatePicker getDateField() {
        return dateField;
    }

    public void setDateField(DatePicker dateField) {
        this.dateField = dateField;
    }

    public TextField getPistaTextField() {
        return pistaTextField;
    }

    public void setPistaTextField(TextField pistaTextField) {
        this.pistaTextField = pistaTextField;
    }

    public TextField getInicioTextField() {
        return inicioTextField;
    }

    public void setInicioTextField(TextField inicioTextField) {
        this.inicioTextField = inicioTextField;
    }

    public TextField getFinTextField() {
        return finTextField;
    }

    public void setFinTextField(TextField finTextField) {
        this.finTextField = finTextField;
    }
}