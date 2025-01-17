module com.example.a {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.a to javafx.fxml;
    exports com.example.a;
}