package com.rackian.dos2translator.controller;

import com.rackian.dos2translator.model.ApiCalls;
import com.rackian.dos2translator.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class CounterController {

    private Counter counter;

    @Autowired
    public CounterController(Counter counter) {
        this.counter = counter;
    }

    @RequestMapping("/counter/currentCalls/")
    @ResponseBody
    public ApiCalls counterCurrent() {
        return counter.getApiCalls();
    }

    @RequestMapping("/counter/totalCalls/")
    @ResponseBody
    public ApiCalls counterTotal() {
        return counter.getApiCallsTotal();
    }

}
