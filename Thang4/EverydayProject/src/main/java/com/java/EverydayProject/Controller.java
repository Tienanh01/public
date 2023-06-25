package com.java.EverydayProject;

import com.java.EverydayProject.Services.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    SendMail sendMail;

    @GetMapping("send-simple-mail")
    public String sendSimpleMail(){

        sendMail.send_SimpleMail();
        return "send mail false";
    }
}
