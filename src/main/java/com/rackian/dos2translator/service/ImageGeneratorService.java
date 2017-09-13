package com.rackian.dos2translator.service;

import com.rackian.dos2translator.model.ImagePack;
import com.rackian.dos2translator.util.TextBoxDimension;
import com.rackian.dos2translator.util.TextBoxFrameDimension;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;

@Service
public class ImageGeneratorService {

    private Robot robot;
    private Dimension screenDimension;
    private TextBoxDimension textBoxDimension;
    private TextBoxFrameDimension textBoxFrameDimension;

    public ImageGeneratorService(
            Robot robot,
            Dimension screenDimension,
            TextBoxDimension textBoxDimension,
            TextBoxFrameDimension textBoxFrameDimension) {
        this.robot = robot;
        this.screenDimension = screenDimension;
        this.textBoxDimension = textBoxDimension;
        this.textBoxFrameDimension = textBoxFrameDimension;
    }

    public ImagePack createImagePack() {
        Rectangle screenRect = new Rectangle(screenDimension);
        BufferedImage fullScreenImage = robot.createScreenCapture(screenRect);
        BufferedImage textBoxImage = fullScreenImage.getSubimage(
                textBoxDimension.getXOffset(),
                textBoxDimension.getYOffset(),
                textBoxDimension.getWidth(),
                textBoxDimension.getHeight());
        BufferedImage textBoxFrameImage = fullScreenImage.getSubimage(
                textBoxFrameDimension.getXOffset(),
                textBoxFrameDimension.getYOffset(),
                textBoxFrameDimension.getWidth(),
                textBoxFrameDimension.getHeight());
        return new ImagePack(fullScreenImage, textBoxImage, textBoxFrameImage);
    }

}
