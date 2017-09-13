package com.rackian.dos2translator.model;

import org.springframework.stereotype.Component;

@Component
public class Counter {

    private long visionApiCalls;
    private long translatedApiCharacters;

    public Counter() {
        visionApiCalls = 0;
        translatedApiCharacters = 0;
    }

    public void incrementVisionApiCalls() {
        visionApiCalls++;
    }

    public void incrementTranslateApiCalls(int characters) {
        visionApiCalls += characters;
    }

    public long getVisionApiCalls() {
        return visionApiCalls;
    }

    public long getTranslatedApiCharacters() {
        return translatedApiCharacters;
    }

}
