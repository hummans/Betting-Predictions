package com.teamproject.bet4life.repositories.base;

import com.teamproject.bet4life.models.UserBet;

import java.util.List;

public interface UserBetRepository {
    List<UserBet> getAll();
    List<UserBet> getLatest3Bets();
}
