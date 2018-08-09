package com.teamproject.bet4life.services.base;

import com.teamproject.bet4life.models.User;

import java.util.List;

public interface UserService extends FieldValueExists{

    List<User> getAllUsers();

    User getUserByID(int id);

    User findByUsername(String username);

    boolean registerUser(User u);

    boolean isExistUsername(String username);

}