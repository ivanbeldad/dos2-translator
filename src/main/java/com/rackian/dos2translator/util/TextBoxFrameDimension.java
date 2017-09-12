package com.rackian.dos2translator.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextBoxFrameDimension {

    private Resolution resolution;

    @Autowired
    public TextBoxFrameDimension(Resolution resolution) {
        this.resolution = resolution;
    }

    public int getWidth() {
        switch (resolution) {
            case ULTRA_WIDE_2k:
                return 20;
            default:
                return 0;
        }
    }

    public int getHeight() {
        switch (resolution) {
            case ULTRA_WIDE_2k:
                return 530;
            default:
                return 0;
        }
    }

    public int getXOffset() {
        switch (resolution) {
            case ULTRA_WIDE_2k:
                return 820;
            default:
                return 0;
        }
    }

    public int getYOffset() {
        switch (resolution) {
            case ULTRA_WIDE_2k:
                return 910;
            default:
                return 0;
        }
    }

}
