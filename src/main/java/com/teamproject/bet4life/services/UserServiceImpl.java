package com.teamproject.bet4life.services;

import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.repositories.base.UserRepository;
import com.teamproject.bet4life.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getAll() {
        return this.userRepository.getAll();
    }
}
