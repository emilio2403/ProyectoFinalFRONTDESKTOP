package es.dylanhurtado.projectfrontdesktop.controllers;

import es.dylanhurtado.projectfrontdesktop.dto.AdminDTO;
import es.dylanhurtado.projectfrontdesktop.rest.Config;
import es.dylanhurtado.projectfrontdesktop.rest.RestOperations;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import retrofit2.Response;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    @FXML
    private TextField emailTextField;
    @FXML
    private HBox hbox;
    @FXML
    private ImageView image;
    @FXML
    private StackPane login;
    @FXML
    private Button loginButton;
    @FXML
    private ImageView imageLoginBackground;
    @FXML
    private TextField passwordTextField;
    @FXML
    private VBox vboxInputs;
    private TranslateTransition loginAnimation;
    private RestOperations restOperations;

    @FXML
    private void login() throws IOException {
        if (!emailTextField.getText().equals("") && !passwordTextField.getText().equals("")) {
            Response loginResponse = restOperations.adminLogin(emailTextField.getText(), passwordTextField.getText()).execute();
            if (loginResponse.isSuccessful() && loginResponse.code() == 200) {
                //AdminDTO admin= (AdminDTO) loginResponse.body();
                loginAnimation = new TranslateTransition(Duration.millis(600), login);
                loginAnimation.setFromY(0);
                loginAnimation.setToY(-3000);
                loginAnimation.play();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inputs incorrectos");
                alert.setHeaderText("El email o el password son incorrectos.");
                alert.show();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inputs vacios");
            alert.setHeaderText("Los campos estan vacios.");
            alert.show();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        restOperations = Config.getService();
    }

    public TextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(TextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public TextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(TextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }
}
