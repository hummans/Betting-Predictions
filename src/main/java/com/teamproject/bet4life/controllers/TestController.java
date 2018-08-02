package com.teamproject.bet4life.controllers;

import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.services.base.BetService;
import com.teamproject.bet4life.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {

    private BetService betService;

    @Autowired
    public TestController(BetService betService) {
        this.betService = betService;
    }


    @RequestMapping("/")
    public String index(Model model) {
        List<Bet> latest3Bets = betService.getLatest3();
        model.addAttribute("latest3Bets", latest3Bets);

        return "index";
    }
}
