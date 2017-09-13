package com.rackian.dos2translator.model;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DialogText {

    private String transmitter;
    private String message;
    private Map<Integer, String> responses;

    public DialogText() {
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
