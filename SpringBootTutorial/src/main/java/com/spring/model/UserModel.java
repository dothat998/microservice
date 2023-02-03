package com.spring.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserModel {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
    private String password;

}
