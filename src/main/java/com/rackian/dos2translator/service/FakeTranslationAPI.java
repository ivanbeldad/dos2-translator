package com.rackian.dos2translator.service;

import com.rackian.dos2translator.model.TranslatedDialogText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class FakeTranslationAPI implements TranslationAPI {

    private TranslatedDialogText translatedDialogText;

    @Autowired
    public FakeTranslationAPI(TranslatedDialogText translatedDialogText) {
        this.translatedDialogText = translatedDialogText;
    }

    @Override
    public void translate() {
        translatedDialogText.setTransmitter("Mr Sandman");
        translatedDialogText.setMessage("Hola a todos!");
        translatedDialogText.setResponses(Collections.singletonMap(1, "(fin)"));
    }

}
