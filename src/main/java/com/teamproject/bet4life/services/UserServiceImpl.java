package com.teamproject.bet4life.services;

import com.teamproject.bet4life.entities.User;
import com.teamproject.bet4life.model.RegistrationModel;
import com.teamproject.bet4life.repositories.base.UserRepository;
import com.teamproject.bet4life.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void register(RegistrationModel registrationModel) {

    }
}
