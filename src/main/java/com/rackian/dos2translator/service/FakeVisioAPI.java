package com.rackian.dos2translator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FakeVisioAPI implements VisionAPI {

    private DialogTextMapperService mapperService;

    @Autowired
    public FakeVisioAPI(DialogTextMapperService mapperService) {
        this.mapperService = mapperService;
    }

    @Override
    public String obtainText() {
        String response = "Magister Waters - Burns me up this happened under our protection. We're extremely lucky no Voidwoken followed\n" +
                "the Source that did this.\n" +
                "1. *Inform her that she wasn't this man's protector; she was his jailer.\n" +
                "2. Ask why she's letting you so close to the crime scene. For all she knows, you could be the killer.*\n" +
                "3. *Take your leave.*";

        System.out.println(mapperService.mapStringToDialogText(response).getTransmitter());
        System.out.println();
        System.out.println(mapperService.mapStringToDialogText(response).getMessage());
        System.out.println();
        Map<Integer, String> responses = mapperService.mapStringToDialogText(response).getResponses();
        for (String r:responses.values()) {
            System.out.println(r);
            System.out.println();
        }
        System.out.println();
        System.out.println();
        return response;
    }

}
