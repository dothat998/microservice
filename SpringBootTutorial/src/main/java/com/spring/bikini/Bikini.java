package com.spring.bikini;

import com.spring.model.Outfit;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("bikini")
//@Primary
public class Bikini implements Outfit {
    @Override
    public void wear(){
        System.out.println("Class Bikini method wear");
    }
}
