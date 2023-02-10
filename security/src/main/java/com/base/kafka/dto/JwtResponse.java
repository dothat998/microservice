package com.base.kafka.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private Date expiryDate;
    private String type = "Bearer";
    private String username;

    private Collection<? extends GrantedAuthority> roles;
    public JwtResponse(String token, String username, Date expiryDate){
        this.token = token;
        this.username = username;
        this.expiryDate = expiryDate;
    }
    public JwtResponse(String token, String username, Date expiryDate,Collection<? extends GrantedAuthority> roles){
        this.token = token;
        this.username = username;
        this.expiryDate = expiryDate;
        this.roles = roles;

    }
}
