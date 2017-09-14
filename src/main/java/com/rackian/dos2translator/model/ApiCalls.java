package com.rackian.dos2translator.model;

public class ApiCalls {

    private long visionApiCalls;
    private long translatedApiCharacters;

    public ApiCalls() {
    }

    public ApiCalls(long visionApiCalls, long translatedApiCharacters) {
        this.visionApiCalls = visionApiCalls;
        this.translatedApiCharacters = translatedApiCharacters;
    }

    public void setTranslatedApiCharacters(long translatedApiCharacters) {
        this.translatedApiCharacters = translatedApiCharacters;
    }

    public void incrementVisionApiCalls() {
        visionApiCalls++;
    }

    public void incrementTranslateApiCalls(int characters) {
        translatedApiCharacters += characters;
    }

    public long getVisionApiCalls() {
        return visionApiCalls;
    }

    public long getTranslatedApiCharacters() {
        return translatedApiCharacters;
    }

}
