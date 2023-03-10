package com.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Girl {
    private String name;

    public Girl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl(String name) {
        this.name = name;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("\t>> Đối tượng Girl sau khi khởi tạo xong sẽ chạy hàm này");
    }
}
