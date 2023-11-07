package com.javafx;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author loyd_
 * @Date 11/3/2023
 */
public class Data {

    int counter = 1;

    public void appendRuntime(Label ticker, TextField talkDurationInMinutes, TextField talkOutlineTitle) {
        System.out.printf("%d. %-80s - %5s min. talk %20s \n", counter, talkOutlineTitle.getText(), talkDurationInMinutes.getText(), ticker.getText());
        counter++;
    }

    public ArrayList<Programs> readFromJSON() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONArray a = (JSONArray) parser.parse(new FileReader("C:\\Users\\loyd_\\IntelliJProjects\\HelloWorldFX\\src\\main\\resources\\com\\javafx\\outlines.json"));
        ArrayList<Programs> programs = new ArrayList<>();
        for (Object o : a) {
            JSONObject obj = (JSONObject) o;

            String number = (String) obj.get("number");

            String talk = (String) obj.get("talk");

            String minute = (String) obj.get("minute");
            String time = (String) obj.get("time");
            String speaker = (String) obj.get("speaker");
            programs.add(new Programs(number, talk, minute));
        }
        return programs;
    }

//    public static void writeJSON(String number, String talk, String minute, String time, String speaker) {
//        JSONObject jsonObject = new JSONObject();
//        //Inserting key-value pairs into the json object
//        jsonObject.put("number", number);
//        jsonObject.put("talk", talk);
//        jsonObject.put("minute", minute);
//        jsonObject.put("time", time);
//        jsonObject.put("speaker", speaker);
//        try {
//            FileWriter file = new FileWriter("src/main/resources/com/javafx/outlines.json", true);
//            file.write(jsonObject.toJSONString());
//            file.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("JSON file created: " + jsonObject);
//    }
}
