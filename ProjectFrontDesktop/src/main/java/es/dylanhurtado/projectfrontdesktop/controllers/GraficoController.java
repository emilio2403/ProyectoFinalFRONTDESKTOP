package es.dylanhurtado.projectfrontdesktop.controllers;


import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GraficoController implements Initializable {


    @FXML
    private CategoryAxis categoryAxis;
    @FXML
    private StackPane grafico;
    @FXML
    private BarChart<String, Integer> graficoBarras;
    @FXML
    private PieChart graficoCircular;
    @FXML
    private HBox graficosWrapper;
    @FXML
    private Button homeButton1;
    @FXML
    private FontIcon homeIcon1;
    @FXML
    private NumberAxis numberAxis;
    private ObservableList<PieChart.Data> datosGraficoCircular;
    private List<Integer> porcentajesCircular;
    private List<Integer> datosGraficosBarras;

    @FXML
    public void hideVistaGraficos() {
        TranslateTransition animation = new TranslateTransition(Duration.millis(600), grafico);
        animation.setFromX(0);
        animation.setToX(3000);
        animation.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loadGraficoCircular() {
        datosGraficoCircular = FXCollections.observableArrayList();
        for (int i = 0; i < porcentajesCircular.size(); i++) {
            datosGraficoCircular.add(new PieChart.Data("Pista "+i, porcentajesCircular.get(i)));
        }
        graficoCircular.setData(datosGraficoCircular);
        graficoCircular.setClockwise(false);
    }

    public void loadGraficoBarras() {
        graficoBarras.getData().clear();
        XYChart.Series<String, Integer> campo;
        for (int i = 0; i < datosGraficosBarras.size(); i++) {
            campo = new XYChart.Series<>();
            campo.setName("Pista "+i);
            campo.getData().add(new XYChart.Data<String,Integer>("", datosGraficosBarras.get(i)));
            graficoBarras.getData().add(campo);
        }
    }

    public List<Integer> getPorcentajesCircular() {
        return porcentajesCircular;
    }

    public void setPorcentajesCircular(List<Integer> porcentajesCircular) {
        this.porcentajesCircular = porcentajesCircular;
    }

    public List<Integer> getDatosGraficosBarras() {
        return datosGraficosBarras;
    }

    public void setDatosGraficosBarras(List<Integer> datosGraficosBarras) {
        this.datosGraficosBarras = datosGraficosBarras;
    }
}
