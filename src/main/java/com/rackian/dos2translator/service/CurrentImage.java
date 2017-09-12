package com.rackian.dos2translator.service;

import com.rackian.dos2translator.util.TextBoxDimension;
import com.rackian.dos2translator.util.TextBoxFrameDimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;

@Service
public class CurrentImage {

    private Robot robot;
    private Dimension screenDimension;
    private TextBoxDimension textBoxDimension;
    private TextBoxFrameDimension textBoxFrameDimension;

    private BufferedImage screenImage;
    private BufferedImage textBoxImage;
    private BufferedImage textBoxFrameImage;

    @Autowired
    public CurrentImage(Robot robot, Dimension screenDimension, TextBoxDimension textBoxDimension, TextBoxFrameDimension textBoxFrameDimension) {
        this.robot = robot;
        this.screenDimension = screenDimension;
        this.textBoxDimension = textBoxDimension;
        this.textBoxFrameDimension = textBoxFrameDimension;
        this.update();
    }

    public BufferedImage getFullScreen() {
        return this.screenImage;
    }

    public BufferedImage getTextBox() {
        return this.textBoxImage;
    }

    public BufferedImage getTextBoxFrame() {
        return this.textBoxFrameImage;
    }

    public void update() {
        Rectangle screenRect = new Rectangle(screenDimension);
        this.screenImage = robot.createScreenCapture(screenRect);
        this.textBoxImage = this.screenImage.getSubimage(
                textBoxDimension.getXOffset(),
                textBoxDimension.getYOffset(),
                textBoxDimension.getWidth(),
                textBoxDimension.getHeight());
        this.textBoxFrameImage = this.screenImage.getSubimage(
                textBoxFrameDimension.getXOffset(),
                textBoxFrameDimension.getYOffset(),
                textBoxFrameDimension.getWidth(),
                textBoxFrameDimension.getHeight());
    }

}
