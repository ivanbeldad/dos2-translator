package com.rackian.dos2translator.service;

import com.rackian.dos2translator.model.CurrentImage;
import com.rackian.dos2translator.model.PreviousImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ImageServiceImpl implements ImageService {

    private VisionAPI visionAPI;
    private TranslationAPI translationAPI;
    private DialogTextMapperService dialogTextMapperService;
    private ImageGeneratorService imageGeneratorService;
    private CurrentImage currentImage;
    private PreviousImage previousImage;
    private ChangeDetector changeDetector;

    @Autowired
    public ImageServiceImpl(
            @Qualifier("googleVisionAPI") VisionAPI visionAPI,
            @Qualifier("googleTranslationAPI") TranslationAPI translationAPI,
            DialogTextMapperService dialogTextMapperService,
            ImageGeneratorService imageGeneratorService,
            CurrentImage currentImage,
            PreviousImage previousImage,
            @Qualifier("changeDetectorImpl") ChangeDetector changeDetector) {
        this.visionAPI = visionAPI;
        this.translationAPI = translationAPI;
        this.dialogTextMapperService = dialogTextMapperService;
        this.imageGeneratorService = imageGeneratorService;
        this.currentImage = currentImage;
        this.previousImage = previousImage;
        this.changeDetector = changeDetector;
    }

    @PostConstruct
    public void init() {
        previousImage.setImagePack(imageGeneratorService.createImagePack());
        currentImage.setImagePack(imageGeneratorService.createImagePack());
    }

    @Scheduled(fixedRate = 1000)
    public void checkChanges() {
        update();
        if (changeDetector.changed()) {
            visionAPI.obtainText();
            translationAPI.translate();
        }
        if (!changeDetector.isTextBox()) {
            dialogTextMapperService.clearDialogs();
        }
    }

    public void update() {
        previousImage.setImagePack(currentImage.getImagePack());
        currentImage.setImagePack(imageGeneratorService.createImagePack());
    }

}
