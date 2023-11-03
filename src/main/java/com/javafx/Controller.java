package com.javafx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Controller {


    @FXML
    Label currentDateTime; @FXML
    Spinner outlines;

    @FXML
    public void initialize () {
//        SimpleDateFormat timeFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss a");
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->
//                currentDateTime.setText(timeFormat.format(Calendar.getInstance().getTime()))
                currentDateTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm:ss a")))
        ),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }


    @FXML
    TextField talkMinutes;
    @FXML
    TextField talkOutlineTitle;
    @FXML
    Menu morningPrograms;
    @FXML
    Menu afternoonPrograms;
    @FXML
    Button startButton;
    @FXML
    Button resetButton;
    @FXML
    Button stopButton;
    @FXML
    MenuItem talkNumberOne;


    @FXML
    protected void startButtonClicks() throws InterruptedException {
        startButton.setText("start");
        talkOutlineTitle.setDisable(true);
        talkMinutes.setDisable(true);
        startButton.setDisable(true);
        resetButton.setDisable(true);
        stopButton.setDisable(false);
    }

    public void resetButtonClicks(ActionEvent actionEvent) {
        startButton.setText("start");
        startButton.setDisable(false);
        resetButton.setDisable(true);
        stopButton.setDisable(true);
    }

    public void stopButtonClicks(ActionEvent actionEvent) {
        startButton.setText("resume");
        talkMinutes.setDisable(false);
        talkOutlineTitle.setDisable(false);
        startButton.setDisable(false);
        resetButton.setDisable(false);
        stopButton.setDisable(true);
    }

    public void selectTalkOutline() {
        for (MenuItem items : morningPrograms.getItems()) {
            items.setOnAction(e -> {
                talkOutlineTitle.setText(items.getText());
                talkMinutes.setText(items.getId());
            });
        }
        for (MenuItem items : afternoonPrograms.getItems()) {
            items.setOnAction(e -> {
                talkOutlineTitle.setText(items.getText());
                talkMinutes.setText(items.getId());
            });
        }
    }
}
