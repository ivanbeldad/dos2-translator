package com.rackian.dos2translator.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextBoxDimension {

    private Resolution resolution;

    @Autowired
    public TextBoxDimension(Resolution resolution) {
        this.resolution = resolution;
    }

    public int getWidth() {
        switch (resolution) {
            case ULTRA_WIDE_2k:
                return 1440;
            default:
                return 0;
        }
    }

    public int getHeight() {
        switch (resolution) {
            case ULTRA_WIDE_2k:
                return 500;
            default:
                return 0;
        }
    }

    public int getXOffset() {
        switch (resolution) {
            case ULTRA_WIDE_2k:
                return 1030;
            default:
                return 0;
        }
    }

    public int getYOffset() {
        switch (resolution) {
            case ULTRA_WIDE_2k:
                return 925;
            default:
                return 0;
        }
    }

}
