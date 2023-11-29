module com.example.motorcycle {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;



    opens com.example.motorcycle to javafx.fxml, com.google.gson;
    exports com.example.motorcycle;
    exports com.example.motorcycle.Controllers;
    opens com.example.motorcycle.Controllers to com.google.gson, javafx.fxml;
    exports com.example.motorcycle.Models;
    opens com.example.motorcycle.Models to com.google.gson, javafx.fxml;
    exports com.example.motorcycle.Utility;
    opens com.example.motorcycle.Utility to com.google.gson, javafx.fxml;
}