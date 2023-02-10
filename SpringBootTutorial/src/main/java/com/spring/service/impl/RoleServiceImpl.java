package com.spring.service.impl;

import com.spring.model.Role;
import com.spring.model.RoleName;
import com.spring.repository.RoleRepository;
import com.spring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        Optional<Role> byName = roleRepository.findByName(name);
        return byName;
    }
}
