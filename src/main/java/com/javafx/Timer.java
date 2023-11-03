package com.javafx;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.util.Duration;
/**
 * @author loyd_
 */

public class Timer {
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;

    Graphics graphics = new Graphics();

    public Timeline runTimeTicker(TextField talkDuration, Label timeTicker) {
        Timeline ticks = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
            String tickerFormat = String.format("%02d:%02d:%02d", hours, minutes, seconds);
            checkTalkDurationAgainstTimeTicker(minutes, talkDuration, timeTicker);

            seconds++;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
            }
            if (minutes == 60) {
                minutes = 0;
                hours++;
            }
            if (hours == 24) {
                minutes = 0;
                timeTicker.setText("OVERTIME");
            }
            timeTicker.setText(String.valueOf(tickerFormat));
        }));
        ticks.setCycleCount(Animation.INDEFINITE);
        ticks.play();
        return ticks;
    }

    public void resetTicker(Label ticker, Button startButton, Button resetButton, Button stopButton) {
        hours = 0;
        minutes = 0;
        seconds = 0;//31,164,93
        ticker.setTextFill(Color.rgb(31, 164, 93, 1));
        ticker.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));

        graphics.uichangesOnResetButton(startButton,resetButton,stopButton);

    }

    public void stopTicker(Timeline timeline, Button startButton, Button resetButton, Button stopButton, TextField talkMinutes, TextField talkOutlineTitle) {
        timeline.stop();
        graphics.uichangesOnStopButton(startButton,resetButton,stopButton,talkMinutes,talkOutlineTitle);

    }
    private void checkTalkDurationAgainstTimeTicker(int minutes, TextField talkDuration, Label timeTicker) {
        if (talkDuration.getText().equalsIgnoreCase(String.valueOf(minutes))) {
            timeTicker.setTextFill(Color.color(1, 0, 0));
        }
    }

}
