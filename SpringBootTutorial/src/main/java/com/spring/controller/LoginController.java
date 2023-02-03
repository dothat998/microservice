package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {
    @GetMapping("index")
    public String showHomePage(){
        return "index";
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
