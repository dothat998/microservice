package com.spring.service;

import com.spring.dto.UserDto;
import com.spring.model.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    public List<UserDto> getListUser();

    public UserDto getListUserId(int id);

    List<UserDto> search(String name);


    Boolean existByUserName(String s);

    Boolean existByEmail(String s);

    UserModel save(UserModel userModel);

}
