package com.rackian.dos2translator.service;

public interface ImageService {

    void update();

    boolean hasChanged();

    boolean isTextBox();

    boolean readyToSend();

}
