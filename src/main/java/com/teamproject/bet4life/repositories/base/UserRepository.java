package com.teamproject.bet4life.repositories.base;

import com.teamproject.bet4life.entities.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();
}
