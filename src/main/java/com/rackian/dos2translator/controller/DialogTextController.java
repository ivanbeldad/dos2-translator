package com.rackian.dos2translator.controller;

import com.rackian.dos2translator.model.OriginalDialogText;
import com.rackian.dos2translator.model.TranslatedDialogText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class DialogTextController {

    private OriginalDialogText originalDialogText;
    private TranslatedDialogText translatedDialogText;

    @Autowired
    public DialogTextController(OriginalDialogText originalDialogText, TranslatedDialogText translatedDialogText) {
        this.originalDialogText = originalDialogText;
        this.translatedDialogText = translatedDialogText;
    }

    @RequestMapping("/dialogText/translated/")
    @ResponseBody
    public TranslatedDialogText translatedDialogText() {
        return translatedDialogText;
    }

    @RequestMapping("/dialogText/original/")
    @ResponseBody
    public OriginalDialogText originalDialogText() {
        return originalDialogText;
    }

}
