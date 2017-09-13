package com.rackian.dos2translator.model;

import java.util.HashMap;
import java.util.Map;

public class DialogText {

    private String transmitter;
    private String message;
    private Map<Integer, String> responses;

    public DialogText() {
        transmitter = "";
        message = "";
        responses = new HashMap<>();
    }

    public String getTransmitter() {
        return transmitter;
    }

    public void setTransmitter(String transmitter) {
        this.transmitter = transmitter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<Integer, String> getResponses() {
        return responses;
    }

    public void setResponses(Map<Integer, String> responses) {
        this.responses = responses;
    }

}
