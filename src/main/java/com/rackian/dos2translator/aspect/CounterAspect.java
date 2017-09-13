package com.rackian.dos2translator.aspect;

import com.rackian.dos2translator.model.Counter;
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

    @Autowired
    public CounterAspect(PrintStream printStream, Counter counter) {
        this.printStream = printStream;
        this.counter = counter;
    }

    @Before("execution(* com.rackian.dos2translator.service.GoogleVisionAPI.obtainText())")
    public void visionApiCalls() {
        counter.incrementVisionApiCalls();
        printStream.println("Vision API called. Current calls: " + counter.getVisionApiCalls() + '\n');
    }

}
