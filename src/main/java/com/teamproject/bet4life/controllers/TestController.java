package com.teamproject.bet4life.controllers;

import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.models.UserBet;
import com.teamproject.bet4life.services.base.BetService;
import com.teamproject.bet4life.services.base.UserBetService;
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

    private UserBetService userBetService;

    @Autowired
    public TestController(UserBetService userBetService) {
        this.userBetService = userBetService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<UserBet> latest3BetsByUser = userBetService.getLatest3Bets();
        model.addAttribute("latest3BetsByUser", latest3BetsByUser);

        return "index";
    }
}
