package com.rackian.dos2translator.util;

import java.awt.image.BufferedImage;

public interface ImageComparator {

    double similarity(BufferedImage image1, BufferedImage image2);

}
