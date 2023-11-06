package com.javafx;

/**
 * @author loyd_
 * @Date 11/6/2023
 */
public class Programs {
    private String number;
    private String talk;
    private String speaker;
    private String minute;
    private double time;

    public Programs(String number, String talk, String minute) {
        this.number = number;
        this.talk = talk;
        this.minute = minute;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Programs{" +
                "number=" + number +
                ", talk='" + talk + '\'' +
                ", speaker='" + speaker + '\'' +
                ", minute=" + minute +
                ", time=" + time +
                '}';
    }
}
