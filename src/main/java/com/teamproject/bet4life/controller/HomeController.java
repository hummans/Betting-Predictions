package com.teamproject.bet4life.controller;

import com.teamproject.bet4life.models.Bet;
import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.services.base.BetService;
import com.teamproject.bet4life.services.base.PredictionService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PredictionService predictionService;

    @GetMapping("/")
    public String index(Model model) {
        // get latest predictions
        List<Prediction> latestPredictions = this.predictionService.getLatest5();

        // add predictions to model
        model.addAttribute("predictions", latestPredictions);

        model.addAttribute("view", "home/index");
        return "base-layout";
    }


}
