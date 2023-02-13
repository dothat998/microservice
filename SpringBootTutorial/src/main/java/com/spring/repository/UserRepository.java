package com.spring.repository;

import com.spring.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    //check user ton tai trong db

    UserModel findByUsername(String username); //tim kiem user co ton tai trong db khong

    Boolean existsByUsername(String s);

    Boolean existsByEmail(String s);

    UserModel save(UserModel userModel);

}
