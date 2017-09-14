package com.rackian.dos2translator.model;

import com.rackian.dos2translator.util.CountReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Counter {

    private ApiCalls apiCalls;
    private ApiCalls apiCallsTotal;

    @Autowired
    public Counter(CountReader countReader) {
        apiCalls = new ApiCalls(0, 0);
        apiCallsTotal = countReader.getApiCalls();
    }

    public void incrementVisionApiCalls() {
        apiCalls.incrementVisionApiCalls();
        apiCallsTotal.incrementVisionApiCalls();
    }

    public void incrementTranslateApiCalls(int characters) {
        apiCalls.incrementTranslateApiCalls(characters);
        apiCallsTotal.incrementTranslateApiCalls(characters);
    }

    public long getVisionApiCalls() {
        return apiCalls.getVisionApiCalls();
    }

    public long getVisionApiCallsTotal() {
        return apiCallsTotal.getVisionApiCalls();
    }

    public long getTranslatedApiCharacters() {
        return apiCalls.getTranslatedApiCharacters();
    }

    public long getTranslatedApiCharactersTotal() {
        return apiCallsTotal.getTranslatedApiCharacters();
    }

    public ApiCalls getApiCalls() {
        return apiCalls;
    }

    public ApiCalls getApiCallsTotal() {
        return apiCallsTotal;
    }

}
