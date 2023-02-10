package com.spring.security.userpincal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {

    private Long id;
    private String name;
    private String userName;
    private String email;
    @JsonIgnore
    private String password;
    private String avatar;
    private Collection<? extends GrantedAuthority> roles;


    public static UserPrinciple build(UserModel userModel){
        //convert list => collection
        List<GrantedAuthority> authorities = userModel.getRoles()
                .stream()
                .map(role-> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new UserPrinciple(
                userModel.getId(),
                userModel.getName(),
                userModel.getUserName(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getAvatar(),
                authorities
        );
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public UserPrinciple(Long id, String name, String userName, String email, String password, String avatar, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.roles = roles;
    }

    //gan userModel -> user cua Security
    /*
    * @author: ThatND
    * @since: 9/2/2023 2:56 PM
    * @description:  authorities ->tro thanh authorities cua he thong
    * @update:
    *
    * */


    public UserPrinciple() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
