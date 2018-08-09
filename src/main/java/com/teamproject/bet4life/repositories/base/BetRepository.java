package com.teamproject.bet4life.repositories.base;

import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.models.Prediction;

import java.util.List;

public interface BetRepository {
    List<Bet> getAllBets();
    List<Bet> getLatest5();
    Bet findByDescription(String description);
}
