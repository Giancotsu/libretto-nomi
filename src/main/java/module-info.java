module com.example.librettovoti {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.librettovoti to javafx.fxml;
    exports com.example.librettovoti;
}