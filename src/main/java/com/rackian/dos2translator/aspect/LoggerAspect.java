package com.rackian.dos2translator.aspect;

import com.rackian.dos2translator.service.DialogTextMapperService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

@Aspect
@Component
public class LoggerAspect {

    private PrintStream printStream;
    private DialogTextMapperService dialogTextMapperService;

//    public LoggerAspect(PrintStream printStream, DialogTextMapperService dialogTextMapperService) {
//        this.printStream = printStream;
//        this.dialogTextMapperService = dialogTextMapperService;
//    }
//
//    @After("execution(* com.rackian.dos2translator.service.VisionAPI.obtainText())")
//    public void visionApi() {
//        printStream.println("Original message:");
//        printStream.println(dialogTextMapperService.mapOriginDialogTextToString() + '\n');
//    }
//
//    @After("execution(* com.rackian.dos2translator.service.TranslationAPI.translate())")
//    public void translatedApi() {
//        printStream.println("Translated message:");
//        printStream.println(dialogTextMapperService.mapTranslatedDialogTextToString() + '\n');
//    }

}
