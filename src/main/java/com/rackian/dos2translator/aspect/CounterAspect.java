package com.rackian.dos2translator.aspect;

import com.rackian.dos2translator.model.Counter;
import com.rackian.dos2translator.service.DialogTextMapperService;
import com.rackian.dos2translator.util.Saver;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.PrintStream;

@Aspect
@Component
public class CounterAspect {

    private PrintStream printStream;
    private Counter counter;
    private DialogTextMapperService dialogTextMapperService;
    private Saver saver;
    private final File FILE = new File("src/main/resources/calls.json");

    @Autowired
    public CounterAspect(
            PrintStream printStream,
            Counter counter,
            DialogTextMapperService dialogTextMapperService,
            Saver saver) {
        this.printStream = printStream;
        this.counter = counter;
        this.dialogTextMapperService = dialogTextMapperService;
        this.saver = saver;
    }

    @Before("execution(* com.rackian.dos2translator.service.VisionAPI.obtainText())")
    public void visionApiCalls() {
        counter.incrementVisionApiCalls();
        saver.save(FILE, counter.getApiCallsTotal());
        printStream.println("Vision API called");
        printStream.println("Current calls: " + counter.getVisionApiCalls());
        printStream.println("Total calls: " + counter.getVisionApiCallsTotal() + '\n');
    }

    @Before("execution(* com.rackian.dos2translator.service.TranslationAPI.translate())")
    public void translateApiCharacter() {
        int characters = dialogTextMapperService.mapOriginDialogTextToString().length();
        counter.incrementTranslateApiCalls(characters);
        saver.save(FILE, counter.getApiCallsTotal());
        printStream.println("Translation API called.");
        printStream.println("Current characters translated:" + counter.getTranslatedApiCharacters());
        printStream.println("Total characters translated:" + counter.getTranslatedApiCharactersTotal() + '\n');
    }

}
