package com.teamproject.bet4life.controllers;

import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.services.base.BetService;
import com.teamproject.bet4life.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {
    private BetService betService;

    @Autowired
    public TestController(BetService betService) {
        this.betService = betService;
    }

    @RequestMapping("/users/all")
    public List<Bet> getAllUsers() {
        return betService.getAll();
    }
}
