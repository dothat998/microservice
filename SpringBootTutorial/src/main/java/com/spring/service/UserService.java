package com.spring.service;

import com.spring.dto.Datatable;
import com.spring.dto.UserDto;
import com.spring.model.UserModel;
import com.spring.request.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    public Page<UserDto>getListUser(Integer page, Integer size);

    public UserDto getListUserId(int id);

    Datatable search(UserRequest request, HttpServletRequest httpServletRequest);


    Boolean existByUserName(String s);

    Boolean existByEmail(String s);

    UserModel save(UserModel userModel);

    void deleteUser(Long id);
}
