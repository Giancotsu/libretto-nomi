module com.example.librettovoti {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.librettovoti to javafx.fxml;
    exports com.example.librettovoti;
}