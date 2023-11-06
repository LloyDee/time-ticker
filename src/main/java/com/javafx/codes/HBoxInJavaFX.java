package com.javafx.codes;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HBoxInJavaFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        Text text = new Text("00:00:00");
//        TextArea area = new TextArea();
        Button one = new Button("One");
//        one.setMaxSize(200,50);
//
        Button two = new Button("Two");
        HBox.setHgrow(text, Priority.ALWAYS);


        hBox.getChildren().addAll(one, text, two);

        Scene scene = new Scene(hBox, 300, 300);

        stage.setScene(scene);
        stage.setTitle("Group Layout");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
