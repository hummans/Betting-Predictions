package com.teamproject.bet4life.services;

import com.teamproject.bet4life.models.UserBet;
import com.teamproject.bet4life.repositories.base.UserBetRepository;
import com.teamproject.bet4life.services.base.UserBetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBetServiceImpl implements UserBetService {
    private UserBetRepository userBetRepository;

    @Autowired
    public UserBetServiceImpl(UserBetRepository userBetRepository) {
        this.userBetRepository = userBetRepository;
    }

    @Override
    public List<UserBet> getAll() {
        return userBetRepository.getAll();
    }

    @Override
    public List<UserBet> getLatest3Bets() {
        return userBetRepository.getLatest3Bets();
    }
}
