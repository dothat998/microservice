package com.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Primary
@Setter
@Getter
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class UserModel extends BaseEntity implements UserDetails, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @JsonIgnore
    @NotBlank
    @Size(min = 3, max = 150)
    private String password;

    //tạo ra những chuỗi văn bản dài.
    @Lob
    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();

    public UserModel(@NotBlank
                     @Size(min = 3, max = 50) String name, @NotBlank
                     @Size(min = 3, max = 50) String username, @NotBlank
                     @Size(max = 50)
                     @Email String email,
                     @NotBlank
                     @Size(min = 3, max = 150) String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserModel() {
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
