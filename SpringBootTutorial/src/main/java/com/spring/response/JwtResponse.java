package com.spring.response;

import com.spring.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private Date expiryDate;
    private String type = "Bearer";
    private String username;

    private Set<Role>roles = new HashSet<>();
    public JwtResponse(String token, String username, Date expiryDate){
        this.token = token;
        this.username = username;
        this.expiryDate = expiryDate;
    }

    public JwtResponse(String token, Date expiryDate , String username, Set<Role> roles) {
        this.token = token;
        this.expiryDate = expiryDate;
        this.username = username;
        this.roles = roles;
    }
}
