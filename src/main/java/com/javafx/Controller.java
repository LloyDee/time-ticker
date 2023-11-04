package com.javafx;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * @author loyd_
 */


public class Controller {

    //controls links to FXML nodes
    @FXML
    Label currentDateTime;
    @FXML
    Label ticker;
    @FXML
    TextField talkDurationInMinutes;
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
    ProgressBar loadingBar;


    //this class is responsible for Clock and Ticker per seconds
    private Timeline ticksPerSeconds;

    //Inherits another Class
    private final Clock clock = new Clock();
    private final Timer timer = new Timer();
    private final Graphics graphics = new Graphics();

    //init the Clock class that's using TimeLine
    public void initialize() {
        clock.initialize(currentDateTime);
    }

    //methods for action event triggered
    @FXML
    protected void startButtonClicks() {

        ticksPerSeconds = timer.runTimeTicker(talkDurationInMinutes, ticker, loadingBar);
        graphics.uiChangesOnStartButton(startButton, resetButton, stopButton, talkDurationInMinutes, talkOutlineTitle);

    }

    @FXML
    protected void resetButtonClicks() {

        timer.resetTicker(ticker, startButton, resetButton, stopButton, loadingBar);

    }


    @FXML
    protected void stopButtonClicks() {

        timer.stopTicker(ticksPerSeconds, startButton, resetButton, stopButton, talkDurationInMinutes, talkOutlineTitle);

    }

    @FXML
    protected void selectTalkOutline() {
        for (MenuItem items : morningPrograms.getItems()) {
            items.setOnAction(actionEvent -> {
                talkOutlineTitle.setText(items.getText());
                talkDurationInMinutes.setText(items.getId());
            });
        }
        for (MenuItem items : afternoonPrograms.getItems()) {
            items.setOnAction(actionEvent -> {
                talkOutlineTitle.setText(items.getText());
                talkDurationInMinutes.setText(items.getId());
            });
        }
    }
}
