package com.teamproject.bet4life.controllers;

import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PredictionController {
    private UserService userService;

    @Autowired
    public PredictionController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/createPrediction", method = RequestMethod.GET)
    public String index(User user) {
        return "createPrediction";
    }

    @RequestMapping(value = "/createPrediction", method = RequestMethod.POST )
    public String createNewPrediction(@ModelAttribute(value="user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "createPrediction";
        }

        model.addAttribute("username", user.getUsername());
        model.addAttribute("fullname", user.getFullname());
        model.addAttribute("password",user.getPassword());
        return "result";
    }

}
