package com.teamproject.bet4life.repositories.base;

import com.teamproject.bet4life.models.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();
}
