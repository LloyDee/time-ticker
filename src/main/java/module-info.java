module com.example.helloworldfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javafx to javafx.fxml;
    exports com.javafx;
}