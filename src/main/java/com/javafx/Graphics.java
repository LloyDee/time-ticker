package com.javafx;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * @author loyd_
 */

public class Graphics {
    public void uichangesOnStartButton(Button startButton, Button resetButton, Button stopButton, TextField talkDurationInMinutes, TextField talkOutlineTitle) {
        startButton.setText("start");
        talkOutlineTitle.setDisable(true);
        talkDurationInMinutes.setDisable(true);
        startButton.setDisable(true);
        resetButton.setDisable(true);
        stopButton.setDisable(false);
    }


    public void uichangesOnResetButton(Button startButton, Button resetButton, Button stopButton) {
        startButton.setText("start");
        startButton.setDisable(false);
        resetButton.setDisable(true);
        stopButton.setDisable(true);
    }

    public void uichangesOnStopButton(Button startButton, Button resetButton, Button stopButton, TextField talkDurationInMinutes, TextField talkOutlineTitle) {
        startButton.setText("resume");
        startButton.setDisable(false);
        resetButton.setDisable(false);
        stopButton.setDisable(true);
        talkDurationInMinutes.setDisable(false);
        talkOutlineTitle.setDisable(false);
    }
}
