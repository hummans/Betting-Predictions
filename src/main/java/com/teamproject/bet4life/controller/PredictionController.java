package com.teamproject.bet4life.controller;

import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.services.base.BetService;
import com.teamproject.bet4life.services.base.PredictionService;
import com.teamproject.bet4life.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @Autowired
    private UserService userService;

    @Autowired
    private BetService betService;


    @GetMapping("/prediction/make")
    @PreAuthorize("isAuthenticated()")
    public String create(Model model) {
        List<Bet> bets = betService.getAllBets();

        model.addAttribute("bets", bets);

        model.addAttribute("view", "prediction/make");

        return "base-layout";
    }
}
