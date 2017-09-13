package com.rackian.dos2translator.model;

import org.springframework.stereotype.Component;

@Component
public class Counter {

    private int visionApiCalls;
    private int translateApiCalls;

    public Counter() {
        visionApiCalls = 0;
        translateApiCalls = 0;
    }

    public void incrementVisionApiCalls() {
        visionApiCalls++;
    }

    public void incrementTranslateApiCalls() {
        visionApiCalls++;
    }

    public int getVisionApiCalls() {
        return visionApiCalls;
    }

    public int getTranslateApiCalls() {
        return translateApiCalls;
    }

}
