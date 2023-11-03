package com.javafx;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Graphics {
    public void uichangesOnStartButton(Button startButton, Button resetButton, Button stopButton, TextField talkMinutes, TextField talkOutlineTitle) {
        startButton.setText("start");
        talkOutlineTitle.setDisable(true);
        talkMinutes.setDisable(true);
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

    public void uichangesOnStopButton(Button startButton, Button resetButton, Button stopButton, TextField talkMinutes, TextField talkOutlineTitle) {
        startButton.setText("resume");
        startButton.setDisable(false);
        resetButton.setDisable(false);
        stopButton.setDisable(true);
        talkMinutes.setDisable(false);
        talkOutlineTitle.setDisable(false);
    }
}
