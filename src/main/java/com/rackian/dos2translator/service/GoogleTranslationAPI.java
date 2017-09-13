package com.rackian.dos2translator.service;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.Translation;
import com.rackian.dos2translator.model.OriginalDialogText;
import com.rackian.dos2translator.model.TranslatedDialogText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoogleTranslationAPI implements TranslationAPI {

    private Translate translate = TranslateOptions.getDefaultInstance().getService();
    private TranslateOption sourceLanguage = TranslateOption.sourceLanguage("en");
    private TranslateOption targeLanguage = TranslateOption.sourceLanguage("es");
    private OriginalDialogText originalDialogText;
    private TranslatedDialogText translatedDialogText;

    @Autowired
    public GoogleTranslationAPI(OriginalDialogText originalDialogText, TranslatedDialogText translatedDialogText) {
        this.originalDialogText = originalDialogText;
        this.translatedDialogText = translatedDialogText;
    }

    @Override
    public void translate() {
        translateMessage();
        translateResponses();
    }

    private void translateMessage() {
        Translation translation = translate.translate(originalDialogText.getMessage(), sourceLanguage, targeLanguage);
        translatedDialogText.setMessage(translation.getTranslatedText());
    }

    private void translateResponses() {
        Map<Integer, String> responses = new HashMap<>();
        for (Integer key:originalDialogText.getResponses().keySet()) {
            Translation translation =
                    translate.translate(originalDialogText.getResponses().get(key), sourceLanguage, targeLanguage);
            responses.put(key, translation.getTranslatedText());
        }
        translatedDialogText.setResponses(responses);
    }

}
