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
    private BarChart<String, Double> graficoBarras;
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
    private List<Double> datosGraficosBarras;

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
        datosGraficoCircular = FXCollections.observableArrayList(
                new PieChart.Data("Tenis", porcentajesCircular.get(0)),
                new PieChart.Data("Baloncesto", porcentajesCircular.get(1)),
                new PieChart.Data("Padel", porcentajesCircular.get(2)),
                new PieChart.Data("Futbol", porcentajesCircular.get(3)),
                new PieChart.Data("Rugby", porcentajesCircular.get(4)),
                new PieChart.Data("Volleyball", porcentajesCircular.get(5)));
        graficoCircular.setData(datosGraficoCircular);
        graficoCircular.setClockwise(false);
    }

    public void loadGraficoBarras() {
        //categoryAxis.setCategories(FXCollections.observableArrayList("Tenis", "Baloncesto", "Padel", "Futbol", "Rugby", "Volleyball"));
        XYChart.Series<String, Double> tenis = new XYChart.Series<>();
        tenis.setName("Tenis");
        tenis.getData().add(new XYChart.Data<>("", datosGraficosBarras.get(0)));
        XYChart.Series<String, Double> baloncesto = new XYChart.Series<>();
        baloncesto.setName("Baloncesto");
        baloncesto.getData().add(new XYChart.Data<>("", datosGraficosBarras.get(1)));
        XYChart.Series<String, Double> padel = new XYChart.Series<>();
        padel.setName("Padel");
        padel.getData().add(new XYChart.Data<>("", datosGraficosBarras.get(2)));
        XYChart.Series<String, Double> futbol = new XYChart.Series<>();
        futbol.setName("Futbol");
        futbol.getData().add(new XYChart.Data<>("", datosGraficosBarras.get(3)));
        XYChart.Series<String, Double> rugby = new XYChart.Series<>();
        rugby.setName("Rugby");
        rugby.getData().add(new XYChart.Data<>("", datosGraficosBarras.get(4)));
        XYChart.Series<String, Double> volley = new XYChart.Series<>();
        volley.setName("Volleyball");
        volley.getData().add(new XYChart.Data<>("", datosGraficosBarras.get(5)));
        graficoBarras.getData().clear();
        graficoBarras.getData().addAll(List.of(tenis, baloncesto, padel, futbol, rugby, volley));
    }

    public List<Integer> getPorcentajesCircular() {
        return porcentajesCircular;
    }

    public void setPorcentajesCircular(List<Integer> porcentajesCircular) {
        this.porcentajesCircular = porcentajesCircular;
    }

    public List<Double> getDatosGraficosBarras() {
        return datosGraficosBarras;
    }

    public void setDatosGraficosBarras(List<Double> datosGraficosBarras) {
        this.datosGraficosBarras = datosGraficosBarras;
    }
}
