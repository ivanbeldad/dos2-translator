package com.rackian.dos2translator.service;

import com.rackian.dos2translator.model.DialogText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogleTranslationAPI implements TranslationAPI {

    private DialogText dialogText;

    @Autowired
    public GoogleTranslationAPI(DialogText dialogText) {
        this.dialogText = dialogText;
    }

    @Override
    public String translate(String text) {
        return null;
    }

}
