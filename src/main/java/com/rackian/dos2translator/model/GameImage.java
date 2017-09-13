package com.rackian.dos2translator.model;

import java.awt.image.BufferedImage;

public interface GameImage {

    BufferedImage getFullScreen();

    BufferedImage getTextBox();

    BufferedImage getTextBoxFrame();

    void setImagePack(ImagePack imagePack);

    ImagePack getImagePack();

}
