package com.javafx;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @author loyd_
 * @Date 11/3/2023
 */
public class Data {

    int counter = 1;

    public void appendRuntime(Label ticker, TextField talkDurationInMinutes, TextField talkOutlineTitle) {
        System.out.printf("%d. %10s - %s min. talk \t|\t%s \n",counter, talkOutlineTitle.getText(), talkDurationInMinutes.getText(),ticker.getText());
        counter++;
    }


}
