package com.base.kafka.controller;

import com.base.kafka.dto.UserDto;
import com.base.kafka.entity.User;
import com.base.kafka.service.iservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200")
public class UserController {
    //Đăng ký
    @Autowired
    UserService userService;
    @PostMapping("")
    public ResponseEntity saveOrUpdate(HttpServletRequest request, @RequestBody UserDto dto){
        return ResponseEntity.ok().body(userService.saveOrUpdate(request, dto));
    }
}
