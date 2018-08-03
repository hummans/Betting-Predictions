package com.teamproject.bet4life.services;

import com.teamproject.bet4life.entities.Bet;
import com.teamproject.bet4life.repositories.base.BetRepository;
import com.teamproject.bet4life.services.base.BetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetServiceImpl implements BetService {
    private BetRepository betRepository;

    public BetServiceImpl(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    @Override
    public List<Bet> getAll() {
        return this.betRepository.getAll();
    }
}
