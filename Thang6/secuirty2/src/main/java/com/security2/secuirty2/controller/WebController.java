package com.security2.secuirty2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class WebController {
    @GetMapping(value = {"/","/home"})
    public String homepage(){
        return "home";
    }
@GetMapping(value = {"/user"})
    public String userpage(){
        return "user";
    }
}
