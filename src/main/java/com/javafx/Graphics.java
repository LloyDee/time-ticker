package com.javafx;

import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
/**
 * @author loyd_
 */

public class Graphics {
    private double progress = 0.0;
    public void uiChangesOnStartButton(Button startButton, Button resetButton, Button stopButton, TextField talkDurationInMinutes, TextField talkOutlineTitle) {


        startButton.setText("start");
        talkOutlineTitle.setDisable(true);
        talkDurationInMinutes.setDisable(true);
        startButton.setDisable(true);
        resetButton.setDisable(true);
        stopButton.setDisable(false);
    }


    public void uiChangesOnResetButton(Button startButton, Button resetButton, Button stopButton) {
        startButton.setText("start");
        progress = 0.0;
        startButton.setDisable(false);
        resetButton.setDisable(true);
        stopButton.setDisable(true);
    }

    public void uiChangesOnStopButton(Button startButton, Button resetButton, Button stopButton, TextField talkDurationInMinutes, TextField talkOutlineTitle) {
        startButton.setText("resume");
        startButton.setDisable(false);
        resetButton.setDisable(false);
        stopButton.setDisable(true);
        talkDurationInMinutes.setDisable(false);
        talkOutlineTitle.setDisable(false);
    }

    public void uiChangesOnProgressBar(TextField talkDuration, ProgressBar loadingBar) {
        loadingBar.setStyle("-fx-accent:green;");
        try {
            double valueFromTalkDuration = Double.parseDouble(talkDuration.getText());
            double totalTalks = valueFromTalkDuration * 60;

            if (progress < totalTalks) {
                // Update the progress based on the difference between totalTalks and progress
                double progressIncrement = totalTalks / (60 * totalTalks * valueFromTalkDuration);
                progress += progressIncrement;
                loadingBar.setProgress(progress);
            }
            if (loadingBar.getProgress() >= 1){

                loadingBar.setStyle("-fx-accent:red;");
            }

        } catch (NumberFormatException e) {
            System.err.println("Invalid input for talk duration");
        }
    }
}
