package com.teamproject.bet4life.services.base;

import com.teamproject.bet4life.models.Role;

public interface RoleService {
    Role findByName(String name);
}
