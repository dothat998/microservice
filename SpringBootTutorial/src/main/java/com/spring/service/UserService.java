package com.spring.service;

import com.spring.dto.UserDto;
import com.spring.model.UserModel;

import java.util.List;

public interface UserService {
    public List<UserDto>getListUser();
    public UserDto getListUserId(int id);

    List<UserDto>search(String name);
}
