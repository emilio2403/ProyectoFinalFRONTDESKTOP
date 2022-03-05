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
        sportTypeSelector.setDisable(true);
        sportTypeSelector.setOpacity(100);
        priceTextField.setEditable(false);
        descriptionTextArea.setEditable(false);
        clientNameTextField.setEditable(false);

    }

    public void unlockTextFields() {
        sportTypeSelector.setDisable(false);
        priceTextField.setEditable(true);
        descriptionTextArea.setEditable(true);
        descriptionTextArea.setStyle(null);
        clientNameTextField.setEditable(true);
    }

    public void clearTextFields() {
        sportTypeSelector.setValue("");
        priceTextField.clear();
        descriptionTextArea.clear();
        clientNameTextField.clear();
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

    public TextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(TextArea descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
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
}