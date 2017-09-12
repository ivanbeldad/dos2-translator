package com.rackian.dos2translator.service;

import com.rackian.dos2translator.util.ImageComparatorImpl;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class TextBoxFrame {

    public boolean isTextBox(BufferedImage image) {
        InputStream is = this.getClass().getResourceAsStream("/textBoxFrame.png");
        BufferedImage frame;
        ImageComparatorImpl impl = new ImageComparatorImpl();
        try {
            frame = ImageIO.read(is);
            double similarity = impl.similarity(frame, image);
            System.out.println("Similarity: " + similarity);
            return true;
        } catch (IOException e) {
            System.out.println("Error reading frame");
            return false;
        }
    }

}
