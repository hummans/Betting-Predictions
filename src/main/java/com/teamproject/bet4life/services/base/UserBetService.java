package com.teamproject.bet4life.services.base;

import com.teamproject.bet4life.models.UserBet;

import java.util.List;

public interface UserBetService {
    List<UserBet> getAll();
    List<UserBet> getLatest3Bets();
}
