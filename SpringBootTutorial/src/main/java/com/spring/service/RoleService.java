package com.spring.service;

import com.spring.model.Role;
import com.spring.model.RoleName;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(RoleName name);
}
