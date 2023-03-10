package com.account.entity;
/*
* @author: ThatND
* @since: 21/2/2023 4:24 PM
* @description:  Người dùng.
* @update:
*
* */
public class AccountDTO {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public AccountDTO() {
    }

    public AccountDTO(String name) {
        this.name = name;
    }
}
