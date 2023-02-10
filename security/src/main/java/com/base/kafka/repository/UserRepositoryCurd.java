package com.base.kafka.repository;


import com.base.kafka.entity.User;

import java.util.List;

public interface UserRepositoryCurd {
    List<User> findByCode (Integer code);
}
