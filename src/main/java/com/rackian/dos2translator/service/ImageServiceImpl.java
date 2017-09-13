package com.rackian.dos2translator.service;

import com.rackian.dos2translator.model.CurrentImage;
import com.rackian.dos2translator.model.PreviousImage;
import com.rackian.dos2translator.util.ImageComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.awt.image.BufferedImage;

@Service
public class ImageServiceImpl implements ImageService {

    private VisionAPI visionAPI;
    private ImageGeneratorService imageGeneratorService;
    private ImageComparator imageComparator;
    private CurrentImage currentImage;
    private PreviousImage previousImage;
    private BufferedImage textBoxFrameImage;
    private double threshold;

    @Autowired
    public ImageServiceImpl(
            @Qualifier("fakeVisioAPI") VisionAPI visionAPI,
            ImageGeneratorService imageGeneratorService,
            ImageComparator imageComparator,
            CurrentImage currentImage,
            PreviousImage previousImage,
            @Qualifier("textBoxFrameImage") BufferedImage textBoxFrameImage,
            @Qualifier("imageComparatorThreshold") double threshold) {
        this.visionAPI = visionAPI;
        this.imageGeneratorService = imageGeneratorService;
        this.imageComparator = imageComparator;
        this.currentImage = currentImage;
        this.previousImage = previousImage;
        this.textBoxFrameImage = textBoxFrameImage;
        this.threshold = threshold;
    }

    @PostConstruct
    public void init() {
        previousImage.setImagePack(imageGeneratorService.createImagePack());
        currentImage.setImagePack(imageGeneratorService.createImagePack());
    }

    @Scheduled(fixedRate = 3000)
    public void checkChanges() {
        update();
        if (readyToSend()) {
            visionAPI.obtainText();
        }
    }

    public void update() {
        previousImage.setImagePack(currentImage.getImagePack());
        currentImage.setImagePack(imageGeneratorService.createImagePack());
    }

    @Override
    public boolean isTextBox() {
        double similarityWithTextBoxFrame =
                imageComparator.similarity(textBoxFrameImage, currentImage.getTextBoxFrame());
        return similarityWithTextBoxFrame > threshold;
    }

    @Override
    public boolean hasChanged() {
        double similarityBetweenPreviousImageAndCurrent =
                imageComparator.similarity(previousImage.getTextBox(), currentImage.getTextBox());
        return similarityBetweenPreviousImageAndCurrent < threshold;
    }

    @Override
    public boolean readyToSend() {
        return isTextBox() && hasChanged();
    }

}
