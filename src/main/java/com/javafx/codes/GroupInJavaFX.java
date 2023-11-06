package com.javafx.codes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GroupInJavaFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Button one = new Button("One");
        Button two = new Button("Two");
        one.setLayoutX(100);
        one.setLayoutY(100);
        two.layoutXProperty().bind(one.layoutXProperty().add(one.widthProperty().add(10)));
        two.layoutYProperty().bind(one.layoutYProperty());

        one.setMaxSize(100,100);
        two.setMaxSize(100,100);
        group.getChildren().addAll(one,two);

        Scene scene = new Scene(group,300,300);

        stage.setScene(scene);
        stage.setTitle("Group Layout");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
