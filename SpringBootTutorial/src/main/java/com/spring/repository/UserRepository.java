package com.spring.repository;

import com.spring.dto.UserDto;
import com.spring.model.UserModel;
import com.spring.request.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    //check user ton tai trong db
    Page<UserModel> findAll(Pageable pageable);
    List<UserModel> findAll();
    UserModel findByUsername(String username); //tim kiem user co ton tai trong db khong

    Boolean existsByUsername(String s);

    Boolean existsByEmail(String s);

    UserModel save(UserModel userModel);



}
