package com.spring.controller;

import com.sib.co.response.SibCoResponse;
import com.spring.dto.UserDto;
import com.spring.model.Role;
import com.spring.model.RoleName;
import com.spring.model.UserModel;
import com.spring.request.SignUpRequest;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;


    public UserController() {
    }

    @PostMapping
    public ResponseEntity<?> addUser() {
        return null;
    }

    @PutMapping
    public ResponseEntity<?> updateUser() {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser() {
        return null;
    }

    @GetMapping
    public ResponseEntity<SibCoResponse<List<UserDto>>> getListUser() {
        List<UserDto> listUser = userService.getListUser();
//        return ResponseEntity.ok(sibCoUtils.buildResponse("listUser",listUser));
        return ResponseEntity.ok(new SibCoResponse<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.toString(), listUser));
    }

    //PathVariable dung de tim kiem tren url theo truong utils
    @GetMapping("/{id}")
    public ResponseEntity<SibCoResponse<UserDto>> getListUserId(@PathVariable int id) {
        UserDto user2 = userService.getListUserId(id);
        return ResponseEntity.ok(new SibCoResponse<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.toString(), user2));
    }

    //@RequestParam truyen vao tham so, de loc theo nhieu truong keyword =?, id=? ? ?
    @GetMapping("/search")
    public ResponseEntity<SibCoResponse<List<UserDto>>> searchUser(@RequestParam String name) {
        return ResponseEntity.ok(new SibCoResponse<>("200", "ok", userService.search(name)));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpRequest request) {
        if (userService.existByUserName(request.getUserName())) {
            return ResponseEntity.ok(new SibCoResponse<>("200", "The username is existed"));
        }
        if (userService.existByEmail(request.getEmail())) {
            return ResponseEntity.ok(new SibCoResponse<>("200", "The email is existed"));
        }
        UserModel userModel = new UserModel(request.getName(), request.getUserName(), request.getEmail(), passwordEncoder.encode(request.getPassword()));
        Set<String> strRoles = request.getRoles();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleService.findByName(RoleName.ADMIN).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(adminRole);
                    break;
                case "pm":
                    Role pmRole = roleService.findByName(RoleName.PM).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleService.findByName(RoleName.USER).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(userRole);

            }
        });
        userModel.setRoles(roles);
        userService.save(userModel);
        return ResponseEntity.ok(new SibCoResponse<>("200", "Data save successfully", userModel));

    }
}
