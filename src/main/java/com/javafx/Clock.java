package com.javafx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Clock {


    public void initialize(Label currentDateTime) {
//      SimpleDateFormat timeFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss a");
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->
//      currentDateTime.setText(timeFormat.format(Calendar.getInstance().getTime()))
                currentDateTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm:ss a")))
        ),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

}
