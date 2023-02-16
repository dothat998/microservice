package com.spring.controller;
import com.sib.co.response.SibCoResponse;
import com.spring.model.UserModel;
import com.spring.request.SignInRequest;
import com.spring.response.JwtResponse;
import com.spring.security.jwt.JwtProvider;
import com.spring.service.RoleService;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtConfig;
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signing")
    public ResponseEntity<?> register(@Valid @RequestBody SignInRequest dto) {
        if (!userService.existByUserName(dto.getUsername())) {
            return ResponseEntity.ok(new SibCoResponse<>("200", "The username no is existed"));
        }
        Date expiryDate;
        String jwtToken;
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserModel userModel = (UserModel) authentication.getPrincipal();
        jwtToken = jwtConfig.createToken(authentication);
        expiryDate = jwtConfig.getExpiryDate(jwtToken);

        return new ResponseEntity<>(new JwtResponse(jwtToken,expiryDate, userDetails.getUsername(),userModel.getRoles()), HttpStatus.OK);
    }

}
