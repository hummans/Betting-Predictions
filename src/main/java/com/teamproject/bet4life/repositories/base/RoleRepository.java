package com.teamproject.bet4life.repositories.base;

import com.teamproject.bet4life.models.Role;

public interface RoleRepository {
    Role findByName(String name);
}
