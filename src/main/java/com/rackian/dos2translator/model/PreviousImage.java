package com.rackian.dos2translator.model;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

@Component
public class PreviousImage extends GameImageImpl {

    public PreviousImage(BufferedImage fullScreen, BufferedImage textBox, BufferedImage textBoxFrame) {
        super(fullScreen, textBox, textBoxFrame);
    }

}
