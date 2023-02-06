package com.spring.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserModel {
    private int id;
    private String fullName;
    private String email;
    private String name;
    private String phone;
    private String avatar;
    private State state;
    private String hashed_password;

    public UserModel(int id, String name, String email, String phone, String avatar, String s3) {
    }
}
