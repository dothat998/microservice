package com.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GirlFriend {
//    @Autowired
//    @Qualifier("bikini")
    public Outfit outfit;

    public Outfit getOutfit() {
        return outfit;
    }

    @Autowired
    public void setOutfit(@Qualifier("dress") Outfit outfit) {
        this.outfit = outfit;
    }

//    @Autowired
    public GirlFriend(Outfit outfit) {
        this.outfit = outfit;
    }
    public GirlFriend() {
    }
}
