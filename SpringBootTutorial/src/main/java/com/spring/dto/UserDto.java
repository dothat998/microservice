package com.spring.dto;

import com.spring.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String avatar;

    public UserDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static <Page> UserDto fromEntity(UserModel userModel) {
        UserDto userDto = new UserDto();
        userDto.setId(Math.toIntExact(userModel.getId()));
        userDto.setEmail(userModel.getEmail());
        userDto.setAvatar(userModel.getAvatar());
        userDto.setName(userModel.getName());
        return userDto;
    }
}
