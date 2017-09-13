package com.rackian.dos2translator.model;

import java.awt.image.BufferedImage;

public class GameImageImpl implements GameImage {

    private BufferedImage fullScreen;
    private BufferedImage textBox;
    private BufferedImage textBoxFrame;

    public GameImageImpl(BufferedImage fullScreen, BufferedImage textBox, BufferedImage textBoxFrame) {
        this.fullScreen = fullScreen;
        this.textBox = textBox;
        this.textBoxFrame = textBoxFrame;
    }

    @Override
    public BufferedImage getFullScreen() {
        return fullScreen;
    }

    @Override
    public BufferedImage getTextBox() {
        return textBox;
    }

    @Override
    public BufferedImage getTextBoxFrame() {
        return textBoxFrame;
    }

    @Override
    public void setImagePack(ImagePack imagePack) {
        fullScreen = imagePack.getFullScreen();
        textBox = imagePack.getTextBox();
        textBoxFrame = imagePack.getTextBoxFrame();
    }

    @Override
    public ImagePack getImagePack() {
        return new ImagePack(fullScreen, textBox, textBoxFrame);
    }

}
