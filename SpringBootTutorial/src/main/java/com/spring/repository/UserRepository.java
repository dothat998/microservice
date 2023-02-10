package com.spring.repository;

import com.spring.model.UserModel;
import com.spring.security.userpincal.UserPrinciple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    //check user ton tai trong db

    UserPrinciple findByUsername(String username);

    Boolean existByUserName(String s);

    Boolean existByEmail(String s);

}
