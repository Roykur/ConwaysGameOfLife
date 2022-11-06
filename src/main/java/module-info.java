module com.example.gameoflifeapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gameoflifeapp to javafx.fxml;
    exports com.example.gameoflifeapp;
}