package com.rackian.dos2translator.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class FakeVisionAPI implements VisionAPI {

    private DialogTextMapperService dialogTextMapperService;

    public FakeVisionAPI(DialogTextMapperService dialogTextMapperService) {
        this.dialogTextMapperService = dialogTextMapperService;
    }

    @Override
    public void obtainText() {
        dialogTextMapperService.mapStringToOriginDialogText("Mr Sandman - Hello everyone!\n1. (end)");
    }

}
