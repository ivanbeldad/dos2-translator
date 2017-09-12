package com.rackian.dos2translator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ImageUpdaterService {

    private CurrentImageService currentImage;

    @Autowired
    public ImageUpdaterService(CurrentImageService currentImage) {
        this.currentImage = currentImage;
    }

    @Scheduled(fixedRate = 1000)
    public void update() {
        System.out.println("Image updated");
        this.currentImage.update();
    }

}
