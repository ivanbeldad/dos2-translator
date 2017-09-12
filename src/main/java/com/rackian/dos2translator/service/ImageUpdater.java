package com.rackian.dos2translator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ImageUpdater implements Runnable {

    private int intervalInMiliseconds;
    private CurrentImage currentImage;

    @Autowired
    public ImageUpdater(@Qualifier("imageUpdaterInterval") int intervalInMiliseconds, CurrentImage currentImage) {
        this.intervalInMiliseconds = intervalInMiliseconds;
        this.currentImage = currentImage;
    }

    public void run() {
        try {
            Thread.sleep(intervalInMiliseconds);
            System.out.println("Image updated");
            this.currentImage.update();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
