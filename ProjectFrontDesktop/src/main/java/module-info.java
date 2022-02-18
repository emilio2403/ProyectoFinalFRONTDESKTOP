module es.dylanhurtado.projectfrontdesktop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens es.dylanhurtado.projectfrontdesktop to javafx.fxml;
    opens es.dylanhurtado.projectfrontdesktop.controllers to javafx.fxml;
    exports es.dylanhurtado.projectfrontdesktop;
}