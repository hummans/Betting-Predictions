package com.teamproject.bet4life.repositories;

import com.teamproject.bet4life.models.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User getUserByID(int id);

    User findByUsername(String username);

    boolean registerUser(User u);

}
