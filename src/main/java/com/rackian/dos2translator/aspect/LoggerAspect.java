package com.rackian.dos2translator.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

@Aspect
@Component
public class LoggerAspect {

    private PrintStream printStream;

    public LoggerAspect(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Before("execution(* com.rackian.dos2translator.service.ImageServiceImpl.checkChanges())")
    public void checking() {
        printStream.println("Checking changes...");
    }

}
