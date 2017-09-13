package com.rackian.dos2translator.service;

import com.rackian.dos2translator.model.DialogText;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DialogTextMapperService {

    private DialogText dialogText;
    private String text;

    public DialogTextMapperService(DialogText dialogText) {
        this.dialogText = dialogText;
    }

    public DialogText mapStringToDialogText(String text) {
        this.text = text;

        setTransmitter();
        setMessage();
        setResponses();

        return dialogText;
    }

    private void setTransmitter() {
        int start = 0;
        int end = text.indexOf(" - ") - 1;
        String transmitter = text.substring(start, end);
        dialogText.setTransmitter(transmitter);
    }

    private void setMessage() {
        int start = text.indexOf(" - ") + 3;
        int end = text.indexOf("\n1. ");
        String message = text.substring(start, end);
        dialogText.setMessage(message);
    }

    private void setResponses() {
        int optionNumber = 1;
        Map<Integer, String> responses = new HashMap<>();
        while (text.contains("\n" + optionNumber + ". ")) {
            int start = text.indexOf("\n" + optionNumber + ". ") + 4;
            int end;
            if (!text.contains("\n" + (optionNumber + 1) + ". ")) {
                end = text.length();
            } else {
                end = text.indexOf("\n" + (optionNumber + 1) + ". ") - 1;
            }
            String response = text.substring(start, end);
            responses.put(optionNumber, response);
            optionNumber++;
        }
        dialogText.setResponses(responses);
    }

    public String mapDialogTextToString() {
        StringBuilder result = new StringBuilder();
        result.append(dialogText.getTransmitter()).append(" - ");
        result.append(dialogText.getMessage()).append('\n');
        for (Integer key:dialogText.getResponses().keySet()) {
            result.append(key).append(". ").append(dialogText.getResponses().get(key)).append('\n');
        }
        return result.toString();
    }

}
