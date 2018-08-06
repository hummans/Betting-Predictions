package com.teamproject.bet4life.service;

import com.teamproject.bet4life.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserByID(int id);

    boolean registerUser(User u);

}