package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping
    public String showHomePage(){
        return "index.html";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }
    @GetMapping("register")
    public String register(){
        return "register";
    }
}
