package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class testBean {
    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(SpringTutorialApplication.class, args);
        SpringApplication.run(SpringTutorialApplication.class, args);

        Girl girl = new Girl();
        girl.setName("abc");
        System.out.println(girl);
    }
}
