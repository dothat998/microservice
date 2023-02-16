package com.spring.controller;

import com.sib.co.contants.SibCoConstant;
import com.sib.co.dto.Datatable;
import com.sib.co.response.SibCoResponse;
import com.spring.dto.UserDto;
import com.spring.model.Role;
import com.spring.model.RoleName;
import com.spring.model.UserModel;
import com.spring.request.SignUpRequest;
import com.spring.request.UserRequest;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);


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
    public ResponseEntity<SibCoResponse<Page<UserDto>>> getListUser(
            @RequestParam(value = "page", defaultValue = SibCoConstant.DEFAULT_PAGE_NUM) Integer page,
            @RequestParam(value = "size", defaultValue = SibCoConstant.DEFAULT_PAGE_SIZE) Integer size) {
        try {
            Page<UserDto> userDto = userService.getListUser(page, size);
            if (userDto.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(new SibCoResponse<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.toString(), userDto));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/search")
    public ResponseEntity<SibCoResponse<Datatable>> search(@RequestBody UserRequest request, HttpServletRequest httpServletRequest) {
        log.debug(" Input request search User: \n {}", request);
        return ResponseEntity.ok(new SibCoResponse<>("200", "OK", userService.search(request, httpServletRequest)));
    }

    //PathVariable dung de tim kiem tren url theo truong utils
    @GetMapping("/{id}")
    public ResponseEntity<SibCoResponse<UserDto>> getUserId(@PathVariable("id") int id) {
        UserDto user2 = userService.getListUserId(id);
        return ResponseEntity.ok(new SibCoResponse<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.toString(), user2));
    }

    //@RequestParam truyen vao tham so, de loc theo nhieu truong keyword =?, id=? ? ?
//    @GetMapping("/search")
//    public ResponseEntity<SibCoResponse<List<UserDto>>> searchUser(@RequestParam String name) {
//        return ResponseEntity.ok(new SibCoResponse<>("200", "ok", userService.search(name)));
//    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUsers(@PathVariable("id") long id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
