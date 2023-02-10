package com.base.kafka.repository;


import com.base.kafka.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCurd  {
    User findByUsername(String username);

    @Query("select o from User o where lower(o.name) like concat('%', :name, '%')")
    List<User> search(String name);
}
