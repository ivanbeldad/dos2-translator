package com.rackian.dos2translator;

import com.rackian.dos2translator.util.Resolution;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintStream;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public Application() {
    }

    static {
        System.setProperty("java.awt.headless", "false");
    }

    @Bean
    public int imageUpdaterInterval() {
        return 1000;
    }

    @Bean
    public double imageComparatorThreshold() {
        return 99.50;
    }

    @Bean
    public BufferedImage textBoxFrameImage() {
        try {
            return ImageIO.read(this.getClass().getResourceAsStream("/textBoxFrame.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public Resolution resolution() {
        return Resolution.ULTRA_WIDE_2k;
    }

    @Bean
    public Robot robot() {
        try {
            return new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public Dimension screenDimension() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    @Bean
    public PrintStream printStream() {
        return System.out;
    }

}
