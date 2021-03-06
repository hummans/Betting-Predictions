package com.teamproject.bet4life.services.base;

import com.teamproject.bet4life.models.Bet;

import java.util.List;

public interface BetService {
    List<Bet> getAll();
    List<Bet> getLatest5();
    Bet findByDescription(String description);
}
