package com.javafx;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

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
    ArrayList<String> recorder = new ArrayList<>();

    int counter = 1;


    //this class is responsible for Clock and Ticker per seconds
    private Timeline ticksPerSeconds;

    //Inherits another Class
    private final Clock clock = new Clock();
    private final Timer timer = new Timer();
    private final Graphics graphics = new Graphics();
    private final Data data = new Data();

    private final ArrayList<Programs> programs = data.readFromJSON();

    public Controller() throws IOException, ParseException {
    }


    //init the Clock class that's using TimeLine
    public void initialize() {

        clock.initialize(currentDateTime);
        initializeMenuItems();

    }

    private void initializeMenuItems() {
        int index = 0;

        for (Programs program:programs){
            MenuItem menuItem = new MenuItem(program.getTalk());
            menuItem.setId(program.getMinute());
            if (index<6){
                morningPrograms.getItems().add(menuItem);
            }else {
                afternoonPrograms.getItems().add(menuItem);
            }
            index++;
        }
    }

    //methods for action event triggered
    @FXML
    protected void onStartButtonClicked() {

        ticksPerSeconds = timer.runTimeTicker(talkDurationInMinutes, ticker, loadingBar);
        graphics.uiChangesOnStartButton(startButton, resetButton, stopButton, talkDurationInMinutes, talkOutlineTitle);

    }



    @FXML
    protected void onResetButtonClicked() {
        timer.resetTicker(ticker, startButton, resetButton, stopButton, loadingBar);

    }


    @FXML
    protected void onStopButtonClicked() throws IOException {
        timer.stopTicker(ticksPerSeconds, startButton, resetButton, stopButton, talkDurationInMinutes, talkOutlineTitle);
        recorder.add(counter + ". " + talkOutlineTitle.getText() + " - " + talkDurationInMinutes.getText() + " min.talk\t|\t" + ticker.getText());
        counter++;
        data.appendRuntime(ticker, talkDurationInMinutes, talkOutlineTitle);
    }

    @FXML
    protected void whenSelectingTalkOutline() {
        for (MenuItem morningProgram : morningPrograms.getItems()) {
            morningProgram.setOnAction(actionEvent -> {
                talkOutlineTitle.setText(morningProgram.getText());
                talkDurationInMinutes.setText(morningProgram.getId());
            });
        }

        for (MenuItem afternoonProgram : afternoonPrograms.getItems()) {
            afternoonProgram.setOnAction(actionEvent -> {
                talkOutlineTitle.setText(afternoonProgram.getText());
                talkDurationInMinutes.setText(afternoonProgram.getId());
            });
        }
    }
    private void handlesNullTimer() {
        System.err.println("Timer object is null. Unable to start the timer.");
    }
}
