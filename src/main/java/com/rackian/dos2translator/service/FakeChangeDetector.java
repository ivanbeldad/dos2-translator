package com.rackian.dos2translator.service;

import org.springframework.stereotype.Service;

@Service
public class FakeChangeDetector implements ChangeDetector {

    private boolean change;

    private void changeGenerator() {
        change = Math.random() > 0.80;
    }

    @Override
    public boolean changed() {
        changeGenerator();
        return change;
    }

    @Override
    public boolean isTextBox() {
        return true;
    }

}
