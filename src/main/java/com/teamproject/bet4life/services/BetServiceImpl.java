package com.teamproject.bet4life.services;

import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.repositories.base.BetRepository;
import com.teamproject.bet4life.services.base.BetService;

import java.util.List;

public class BetServiceImpl implements BetService {
    private BetRepository BetRepository;

    public BetServiceImpl(BetRepository betRepository) {
        this.BetRepository = betRepository;
    }

    @Override
    public List<Bet> getAll() {
        return this.BetRepository.getAll();
    }
}
