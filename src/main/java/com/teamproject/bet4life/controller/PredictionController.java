package com.teamproject.bet4life.controller;

import com.teamproject.bet4life.bindingModels.PredictionBindingModel;
import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.services.base.BetService;
import com.teamproject.bet4life.services.base.PredictionService;
import com.teamproject.bet4life.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String make(Model model) {
        List<Bet> bets = this.betService.getAll();

        model.addAttribute("bets", bets);

        model.addAttribute("view", "prediction/make");

        return "base-layout";
    }

    @PostMapping("/prediction/make")
    @PreAuthorize("isAuthenticated()")
    public String makeProcess(PredictionBindingModel predictionBindingModel) {
        // get currently logged user
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
                                                                    .getAuthentication()
                                                                    .getPrincipal();

        // extract user from database
        User user = this.userService.findByUsername(principal.getUsername());

        // extract bet from database
        Bet bet = this.betService.findByDescription(predictionBindingModel.getBetDescription());
        

        Prediction newPrediction = new Prediction(
                                    predictionBindingModel.getContent(),
                                    user,
                                    bet
        );

        this.predictionService.savePrediction(newPrediction);

        return "redirect:/";

    }


}
