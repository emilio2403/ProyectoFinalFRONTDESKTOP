package es.dylanhurtado.projectfrontdesktop.controllers;

import es.dylanhurtado.projectfrontdesktop.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class UserController {

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextField emailTextField;

    @FXML
    private HBox hboxImageForm;

    @FXML
    private ImageView image;

    @FXML
    private StackPane imageWrapper;

    @FXML
    private StackPane user;

    @FXML
    private TextField userTextField;

    @FXML
    private VBox vboxFormWrapper;

    @FXML
    private VBox vboxUser;
    private User selectedItem;

    public void setUsuarioSelected(User selectedItem) {
        this.selectedItem = selectedItem;

    }
    
    public void blockTextFields() {
        emailTextField.setEditable(false);
        userTextField.setEditable(false);
        descriptionTextArea.setEditable(false);
    }

    public void unlockTextFields() {
        emailTextField.setEditable(true);
        userTextField.setEditable(true);
        descriptionTextArea.setEditable(true);
    }

    public void clearTextFields() {
        emailTextField.clear();
        userTextField.clear();
        descriptionTextArea.clear();
    }

    public User getSelectedItem() {
        return selectedItem;
    }

    public TextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(TextArea descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }

    public TextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(TextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public TextField getUserTextField() {
        return userTextField;
    }

    public void setUserTextField(TextField userTextField) {
        this.userTextField = userTextField;
    }
}
