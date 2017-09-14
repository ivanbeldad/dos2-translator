package com.rackian.dos2translator.controller;

import com.google.common.io.ByteStreams;
import com.rackian.dos2translator.service.ImageGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
@CrossOrigin
public class ScreenCapturerController {

    private ImageGeneratorService imageGeneratorService;

    @Autowired
    public ScreenCapturerController(ImageGeneratorService imageGeneratorService) {
        this.imageGeneratorService = imageGeneratorService;
    }

    @RequestMapping("/textBoxFrame/")
    @ResponseBody
    public ResponseEntity<byte[]> textBoxFrame() throws IOException {
        InputStream is = this.getClass().getResourceAsStream("/textBoxFrame.png");
        byte[] bytes = ByteStreams.toByteArray(is);
        return ResponseEntity.ok()
                .contentLength(bytes.length)
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }

    @RequestMapping(value = "/textBoxFrame/generate/")
    @ResponseBody
    public ResponseEntity textBoxFrameGenerate() throws IOException {
        BufferedImage image = imageGeneratorService.createImagePack().getTextBoxFrame();
        File file = new File("src/main/resources/textBoxFrame.png");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", byteArrayOutputStream);
        ImageIO.write(image, "png", file);
        return ResponseEntity.ok()
                .contentLength(byteArrayOutputStream.toByteArray().length)
                .contentType(MediaType.IMAGE_PNG)
                .body(byteArrayOutputStream.toByteArray());
    }

    @RequestMapping(value = "/textBox/generate/")
    @ResponseBody
    public ResponseEntity textBoxGenerate() throws IOException {
        BufferedImage image = imageGeneratorService.createImagePack().getTextBox();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "gif", byteArrayOutputStream);
        return ResponseEntity.ok()
                .contentLength(byteArrayOutputStream.toByteArray().length)
                .contentType(MediaType.IMAGE_PNG)
                .body(byteArrayOutputStream.toByteArray());
    }

}
