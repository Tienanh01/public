package com.security.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping({"/","/home"})
    public String homepage(){
        return "home";
    }
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
