package com.teamproject.bet4life.services;

import com.teamproject.bet4life.models.Role;
import com.teamproject.bet4life.repositories.base.RoleRepository;
import com.teamproject.bet4life.services.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
