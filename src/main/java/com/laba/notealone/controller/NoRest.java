package com.laba.notealone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NoRest {
    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @GetMapping("/asd")
    @ResponseBody
    public String login1() {
        return "index";
    }
}
