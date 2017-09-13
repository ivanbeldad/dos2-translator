package com.rackian.dos2translator.aspect;

import com.rackian.dos2translator.model.Counter;
import com.rackian.dos2translator.model.OriginalDialogText;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

@Aspect
@Component
public class CounterAspect {

    private PrintStream printStream;
    private Counter counter;
    private OriginalDialogText originalDialogText;

    @Autowired
    public CounterAspect(PrintStream printStream, Counter counter, OriginalDialogText originalDialogText) {
        this.printStream = printStream;
        this.counter = counter;
        this.originalDialogText = originalDialogText;
    }

    @Before("execution(* com.rackian.dos2translator.service.GoogleVisionAPI.obtainText())")
    public void visionApiCalls() {
        counter.incrementVisionApiCalls();
        printStream.println("Vision API called. Current calls: " + counter.getVisionApiCalls() + '\n');
    }

    @Before("execution(* com.rackian.dos2translator.service.GoogleTranslationAPI.translate(..))")
    public void translateApiCharacter() {
        int characters = originalDialogText.getMessage().length();
        for (String response:originalDialogText.getResponses().values()) {
            characters += response.length();
        }
        counter.incrementTranslateApiCalls(characters);
        printStream.println("Translation API called. Current characters translated: " +
                counter.getTranslatedApiCharacters() + '\n');
    }

}
