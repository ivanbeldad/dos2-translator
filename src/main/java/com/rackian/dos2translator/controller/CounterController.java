package com.rackian.dos2translator.controller;

import com.rackian.dos2translator.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CounterController {

    private Counter counter;

    @Autowired
    public CounterController(Counter counter) {
        this.counter = counter;
    }

    @RequestMapping("/counter/")
    @ResponseBody
    public Counter counter() {
        return counter;
    }

}
