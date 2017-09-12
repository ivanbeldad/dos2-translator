package com.rackian.dos2translator.service;

import com.rackian.dos2translator.util.ImageComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class ImageComparatorService {

    private BufferedImage textBoxFrame;
    private CurrentImage currentImage;
    private ImageComparator comparator;
    private double threshold;

    @Autowired
    public ImageComparatorService(@Qualifier("textBoxFrame") BufferedImage textBoxFrame, CurrentImage currentImage, ImageComparator comparator, @Qualifier("imageComparatorThreshold") double threshold) {
        this.textBoxFrame = textBoxFrame;
        this.currentImage = currentImage;
        this.comparator = comparator;
        this.threshold = threshold;
    }

    public boolean isTextBox() {
        return this.comparator.similarity(textBoxFrame, currentImage.getTextBoxFrame()) > threshold;
    }

}
