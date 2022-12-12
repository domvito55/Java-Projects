module com.example.matheus_17_lab4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.matheus_17_lab4 to javafx.fxml;
    exports com.example.matheus_17_lab4;
}