package com.rackian.dos2translator.util;

public enum Resolution {

    ULTRA_WIDE_2k(3440, 1440);

    private int width;
    private int height;

    Resolution(int width, int height) {
        this.width = width;
        this.height = height;
    }

}
