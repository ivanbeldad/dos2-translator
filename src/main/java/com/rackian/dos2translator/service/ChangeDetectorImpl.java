package com.rackian.dos2translator.service;

import com.rackian.dos2translator.model.CurrentImage;
import com.rackian.dos2translator.model.PreviousImage;
import com.rackian.dos2translator.util.ImageComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class ChangeDetectorImpl implements ChangeDetector {

    private ImageComparator imageComparator;
    private CurrentImage currentImage;
    private PreviousImage previousImage;
    private BufferedImage textBoxFrameImage;
    private double threshold;

    @Autowired
    public ChangeDetectorImpl(
            ImageComparator imageComparator,
            CurrentImage currentImage,
            PreviousImage previousImage,
            @Qualifier("textBoxFrameImage") BufferedImage textBoxFrameImage,
            @Qualifier("imageComparatorThreshold") double threshold) {
        this.imageComparator = imageComparator;
        this.currentImage = currentImage;
        this.previousImage = previousImage;
        this.textBoxFrameImage = textBoxFrameImage;
        this.threshold = threshold;
    }

    @Override
    public boolean changed() {
        return isTextBox() && hasChanged();
    }

    @Override
    public boolean isTextBox() {
        double similarityWithTextBoxFrame =
                imageComparator.similarity(textBoxFrameImage, currentImage.getTextBoxFrame());
        return similarityWithTextBoxFrame > threshold;
    }

    private boolean hasChanged() {
        double similarityBetweenPreviousImageAndCurrent =
                imageComparator.similarity(previousImage.getTextBox(), currentImage.getTextBox());
        return similarityBetweenPreviousImageAndCurrent < threshold;
    }

}
