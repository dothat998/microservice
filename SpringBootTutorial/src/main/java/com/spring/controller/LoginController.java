package com.spring.controller;

import com.sib.co.response.SibCoResponse;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpRequest request) {
        if (userService.existByUserName(request.getUserName())) {
            return ResponseEntity.ok(new SibCoResponse<>(HttpStatus.OK.getReasonPhrase(), "The username is existed"));
        }
        if (userService.existByEmail(request.getEmail())) {
            return ResponseEntity.ok(new SibCoResponse<>(HttpStatus.OK.getReasonPhrase(), "The email is existed"));
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
                case "user":
                    Role userRole = roleService.findByName(RoleName.USER).orElseThrow(() -> new RuntimeException("Role not found"));
                    roles.add(userRole);
                    break;
            }
        });
        userModel.setRoles(roles);
        userService.save(userModel);
        return ResponseEntity.ok(new SibCoResponse<>(HttpStatus.OK.getReasonPhrase(), "Data save successfully", userModel));

    }

}
