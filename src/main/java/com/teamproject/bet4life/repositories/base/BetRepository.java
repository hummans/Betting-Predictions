package com.teamproject.bet4life.repositories.base;

import com.teamproject.bet4life.models.Bet;

import java.util.List;

public interface BetRepository {
    List<Bet> getAll();
    List<Bet> getLatest3();
}
