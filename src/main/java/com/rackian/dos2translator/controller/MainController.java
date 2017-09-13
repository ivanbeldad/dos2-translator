package com.rackian.dos2translator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String main() {
        return "Working";
    }

}
