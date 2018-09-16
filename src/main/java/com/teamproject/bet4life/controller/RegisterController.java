/*
package com.teamproject.bet4life.controller;

import com.teamproject.bet4life.RegistrationModel.RegistrationModel;
import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(@ModelAttribute RegistrationModel registrationModel){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute RegistrationModel registrationModel, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "register";
        }

        User u = new User();
        u.setUsername(registrationModel.getUsername());
        u.setPassword(registrationModel.getPassword());
        userService.registerUser(u);
        return "redirect:/";
    }
}
*/
