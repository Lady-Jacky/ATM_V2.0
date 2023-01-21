module com.example.atm_v2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.atm_v2 to javafx.fxml;
    exports com.example.atm_v2;
}