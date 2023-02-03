package com.spring.model;

import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("dress")
//@Scope("prototype")
//@Primary
public class Dress implements Outfit{
    @Override
    public void wear() {
        System.out.println("Class Dress method wear");
    }
}
