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
    private Object selectedItem;

    public void setUsuarioSelected(Object selectedItem) {
        this.selectedItem=selectedItem;

    }
}
