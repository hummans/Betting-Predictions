package com.teamproject.bet4life.repositories;

import com.teamproject.bet4life.models.Role;

public interface RoleRepository {
    Role finbByName(String name);
}
