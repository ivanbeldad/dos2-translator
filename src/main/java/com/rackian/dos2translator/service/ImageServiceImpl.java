package com.rackian.dos2translator.service;

import com.rackian.dos2translator.model.CurrentImage;
import com.rackian.dos2translator.model.PreviousImage;
import com.rackian.dos2translator.util.ImageComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageGeneratorService imageGeneratorService;
    private ImageComparator imageComparator;
    private CurrentImage currentImage;
    private PreviousImage previousImage;
    private BufferedImage textBoxFrameImage;
    private double threshold;

    @Autowired
    public ImageServiceImpl(
            ImageGeneratorService imageGeneratorService,
            ImageComparator imageComparator,
            CurrentImage currentImage,
            PreviousImage previousImage,
            @Qualifier("textBoxFrameImage") BufferedImage textBoxFrameImage,
            @Qualifier("imageComparatorThreshold") double threshold) {
        this.imageGeneratorService = imageGeneratorService;
        this.imageComparator = imageComparator;
        this.currentImage = currentImage;
        this.previousImage = previousImage;
        this.textBoxFrameImage = textBoxFrameImage;
        this.threshold = threshold;
    }

    @Scheduled(fixedRate = 1000)
    public void schedule() {
        System.out.println("Image updated");
        update();
    }

    public void update() {
        previousImage.setImagePack(currentImage.getImagePack());
        currentImage.setImagePack(imageGeneratorService.createImagePack());
    }

    @Override
    public boolean textBox() {
        return imageComparator.similarity(textBoxFrameImage, currentImage.getTextBoxFrame()) > threshold;
    }

    @Override
    public boolean changed() {
        return imageComparator.similarity(previousImage.getTextBox(), previousImage.getTextBox()) > threshold;
    }

}
