package es.dylanhurtado.projectfrontdesktop.controllers;

import es.dylanhurtado.projectfrontdesktop.model.Pista;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class PistaController {

    @FXML
    private TextArea descriptionTextField;

    @FXML
    private HBox hboxPista;

    @FXML
    private ImageView image;

    @FXML
    private StackPane imageWrapper;

    @FXML
    private StackPane pista;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField aperturaField;

    @FXML
    private TextField cierreTextField;

    @FXML
    private VBox vboxForm;
    private Pista selectedItem;

    public void setPistaSelected(Pista selectedItem) {
        this.selectedItem = selectedItem;
    }

    public Pista getSelectedItem() {
        return selectedItem;
    }

    public void blockTextFields() {
        titleTextField.setEditable(false);
        priceTextField.setEditable(false);
        descriptionTextField.setEditable(false);
        aperturaField.setEditable(false);
        cierreTextField.setEditable(false);

    }

    public void unlockTextFields() {
        titleTextField.setEditable(true);
        priceTextField.setEditable(true);
        descriptionTextField.setEditable(true);
        aperturaField.setEditable(true);
        cierreTextField.setEditable(true);
    }

    public void clearTextFields() {
        titleTextField.clear();
        priceTextField.clear();
        descriptionTextField.clear();
        aperturaField.clear();
        cierreTextField.clear();
    }


    public TextArea getDescriptionTextField() {
        return descriptionTextField;
    }

    public void setDescriptionTextField(TextArea descriptionTextField) {
        this.descriptionTextField = descriptionTextField;
    }

    public TextField getPriceTextField() {
        return priceTextField;
    }

    public void setPriceTextField(TextField priceTextField) {
        this.priceTextField = priceTextField;
    }

    public TextField getTitleTextField() {
        return titleTextField;
    }

    public void setTitleTextField(TextField titleTextField) {
        this.titleTextField = titleTextField;
    }

    public TextField getAperturaField() {
        return aperturaField;
    }

    public void setAperturaField(TextField aperturaField) {
        this.aperturaField = aperturaField;
    }

    public TextField getCierreTextField() {
        return cierreTextField;
    }

    public void setCierreTextField(TextField cierreTextField) {
        this.cierreTextField = cierreTextField;
    }
}
