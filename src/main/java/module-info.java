module com.example.helloworldfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.javafx to javafx.fxml;
    exports com.javafx;
//    exports com.javafx.codes;
//    opens com.javafx.codes to javafx.fxml;
//    exports com.javafx.codes;
//    opens com.javafx.codes to javafx.fxml;
}