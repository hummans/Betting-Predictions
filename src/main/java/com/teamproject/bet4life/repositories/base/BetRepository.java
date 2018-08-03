package com.teamproject.bet4life.repositories.base;

import com.teamproject.bet4life.entities.Bet;

import java.util.List;

public interface BetRepository {
    List<Bet> getAll();
}
