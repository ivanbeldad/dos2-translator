package com.rackian.dos2translator.model;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

@Component
public class CurrentImage extends GameImageImpl {

    public CurrentImage(BufferedImage fullScreen, BufferedImage textBox, BufferedImage textBoxFrame) {
        super(fullScreen, textBox, textBoxFrame);
    }

}
