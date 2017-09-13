package com.rackian.dos2translator.service;

import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import com.rackian.dos2translator.model.CurrentImage;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Service
public class GoogleVisionAPI implements VisionAPI {

    private CurrentImage currentImage;

    public GoogleVisionAPI(CurrentImage currentImage) {
        this.currentImage = currentImage;
    }

    @Override
    public String obtainText() {
        try {
            ImageAnnotatorClient vision = ImageAnnotatorClient.create();

            // EXECUTE THE REQUEST AND GET RESPONSE
            BatchAnnotateImagesResponse response = vision.batchAnnotateImages(Collections.singletonList(getRequest()));
            List<AnnotateImageResponse> responses = response.getResponsesList();

            List<EntityAnnotation> annotations = responses.get(0).getTextAnnotationsList();
            System.out.println(annotations.get(0).getDescription());
            return annotations.get(0).getDescription();
        } catch (Exception ex) {
            return "";
        }
    }

    private AnnotateImageRequest getRequest() throws IOException {
        AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                .addFeatures(getFeature())
                .setImage(getImage())
                .build();
        return request;
    }

    private Feature getFeature() {
        return Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
    }

    private Image getImage() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(currentImage.getTextBox(),"gif", os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        ByteString imgBytes = ByteString.readFrom(is);
        Image image = Image.newBuilder().setContent(imgBytes).build();
        return image;
    }

}
