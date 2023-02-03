package com.spring.controller;

import com.sib.co.response.SibCoResponse;
import com.sib.co.utils.SibCoUtils;
import com.spring.dto.UserDto;
import com.spring.model.UserModel;
import com.spring.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {
//    @Autowired
//    SibCoUtils sibCoUtils;
    @Autowired
    private UserServiceImpl userService;

    public UserController() {
    }

    @PostMapping
    public ResponseEntity<?> addUser(){
        return null;
    }
    @PutMapping
    public ResponseEntity<?> updateUser(){
        return null;
    }
    @DeleteMapping
    public ResponseEntity<?> deleteUser(){
        return null;
    }
    @GetMapping
    public ResponseEntity<SibCoResponse<List<UserDto>>> getListUser(){
        List<UserDto> listUser = userService.getListUser();
//        return ResponseEntity.ok(sibCoUtils.buildResponse("listUser",listUser));
        return ResponseEntity.ok(new SibCoResponse<>(HttpStatus.OK.getReasonPhrase(),HttpStatus.OK.toString(),listUser));
    }

    //PathVariable dung de tim kiem tren url theo truong utils
    @GetMapping("/{id}")
    public ResponseEntity<SibCoResponse<UserDto>> getListUserId(@PathVariable int id){
         UserDto user2 = userService.getListUserId(id);
        return ResponseEntity.ok(new SibCoResponse<>(HttpStatus.OK.getReasonPhrase(),HttpStatus.OK.toString(),user2));
    }

    //@RequestParam truyen vao tham so, de loc theo nhieu truong keyword =?, id=? ? ?
    @GetMapping("/search")
    public ResponseEntity<SibCoResponse<List<UserDto>>> searchUser(@RequestParam String name){
        return ResponseEntity.ok(new SibCoResponse<>("200","ok",userService.search(name)));
    }

}
