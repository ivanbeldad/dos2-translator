package com.rackian.dos2translator.service;

import com.rackian.dos2translator.model.DialogText;
import com.rackian.dos2translator.model.OriginalDialogText;
import com.rackian.dos2translator.model.TranslatedDialogText;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DialogTextMapperService {

    private OriginalDialogText originalDialogText;
    private TranslatedDialogText translatedDialogText;
    private String originText;

    public DialogTextMapperService(OriginalDialogText originalDialogText, TranslatedDialogText translatedDialogText) {
        this.originalDialogText = originalDialogText;
        this.translatedDialogText = translatedDialogText;
    }

    public void mapStringToOriginDialogText(String text) {
        this.originText = text;

        setTransmitter(originText, originalDialogText);
        setMessage(originText, originalDialogText);
        setResponses(originText, originalDialogText);
    }

    private void setTransmitter(String text, DialogText dialogText) {
        int start = 0;
        int end = text.indexOf(" - ");
        String transmitter = text.substring(start, end);
        dialogText.setTransmitter(transmitter);
    }

    private void setMessage(String text, DialogText dialogText) {
        int start = text.indexOf(" - ") + 3;
        int end = text.indexOf("\n1. ");
        String message = text.substring(start, end);
        dialogText.setMessage(message);
    }

    private void setResponses(String text, DialogText dialogText) {
        int optionNumber = 1;
        Map<Integer, String> responses = new HashMap<>();
        while (text.contains("\n" + optionNumber + ". ")) {
            int start = startOfNumber(text, optionNumber);
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

    private int startOfNumber(String text, int number) {
        int start = text.indexOf("\n" + number + ". ");
        if (start == -1) {
            start = text.indexOf("\n" + number + ", ");
        }
        start += 4;
        return start;
    }

    public String mapOriginDialogTextToString() {
        return mapDialogTextToString(originalDialogText);
    }

    public String mapTranslatedDialogTextToString() {
        return mapDialogTextToString(translatedDialogText);
    }

    private String mapDialogTextToString(DialogText dialogText) {
        StringBuilder result = new StringBuilder();
        result.append(dialogText.getTransmitter()).append(" - ");
        result.append(dialogText.getMessage()).append('\n');
        for (Integer key:dialogText.getResponses().keySet()) {
            result.append(key).append(". ").append(dialogText.getResponses().get(key)).append('\n');
        }
        return result.toString();
    }

}
