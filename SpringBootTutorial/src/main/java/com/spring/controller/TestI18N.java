package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestI18N {

    @GetMapping("/i18n")
    public String geti18N(){
        return "i18n";
    }
}
