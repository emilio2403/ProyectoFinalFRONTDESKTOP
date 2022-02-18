package es.dylanhurtado.projectfrontdesktop.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ListController {

    @FXML
    private StackPane list;

    @FXML
    private ListView<?> listView;

    @FXML
    private Label typeLabel;

    @FXML
    private VBox vbox;
}

