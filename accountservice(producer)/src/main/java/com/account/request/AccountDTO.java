package com.account.request;

import lombok.Data;

import javax.persistence.Column;
import java.util.Set;

@Data
public class AccountDTO {

    private Long id;

    private String name;

    private String password;
    private String username;

    private Set<String>roles;
}


