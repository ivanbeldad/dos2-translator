package com.rackian.dos2translator.model;

import java.awt.image.BufferedImage;

public class ImagePack {

    private BufferedImage fullScreen;
    private BufferedImage textBox;
    private BufferedImage textBoxFrame;

    public ImagePack(BufferedImage fullScreen, BufferedImage textBox, BufferedImage textBoxFrame) {
        this.fullScreen = fullScreen;
        this.textBox = textBox;
        this.textBoxFrame = textBoxFrame;
    }

    public BufferedImage getFullScreen() {
        return fullScreen;
    }

    public BufferedImage getTextBox() {
        return textBox;
    }


    public BufferedImage getTextBoxFrame() {
        return textBoxFrame;
    }

}
