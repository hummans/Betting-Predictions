package com.teamproject.bet4life.services.base;

import com.teamproject.bet4life.models.Bet;

import java.util.List;

public interface BetService {
    List<Bet> getAll();

    Bet findByDescription(String description);
}
