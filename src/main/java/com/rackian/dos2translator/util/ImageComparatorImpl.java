package com.rackian.dos2translator.util;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

@Component
public class ImageComparatorImpl implements ImageComparator {

    public double similarity(BufferedImage image1, BufferedImage image2) {
        long diff = 0;
        int width1 = image1.getWidth(null);
        int width2 = image2.getWidth(null);
        int height1 = image1.getHeight(null);
        int height2 = image2.getHeight(null);

        if ((width1 != width2) || (height1 != height2)) {
            System.err.println("Error: Images dimensions mismatch");
            System.exit(1);
        }

        for (int y = 0; y < height1; y++) {
            for (int x = 0; x < width1; x++) {
                int rgb1 = image1.getRGB(x, y);
                int rgb2 = image2.getRGB(x, y);
                int r1 = (rgb1 >> 16) & 0xff;
                int g1 = (rgb1 >>  8) & 0xff;
                int b1 = (rgb1      ) & 0xff;
                int r2 = (rgb2 >> 16) & 0xff;
                int g2 = (rgb2 >>  8) & 0xff;
                int b2 = (rgb2      ) & 0xff;
                diff += Math.abs(r1 - r2);
                diff += Math.abs(g1 - g2);
                diff += Math.abs(b1 - b2);
            }
        }

        double n = width1 * height1 * 3;
        double p = diff / n / 255.0;
        double result = p * 100.0;
        double rounded = round(result, 3);
        double similarity = (100 - rounded);
        return similarity;
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
