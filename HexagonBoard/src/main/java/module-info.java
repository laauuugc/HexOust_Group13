module comp20050.hexagonboard {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens comp20050.hexagonboard to javafx.fxml;
    exports comp20050.hexagonboard;
}