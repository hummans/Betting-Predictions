package com.teamproject.bet4life.controller;

import com.teamproject.bet4life.bindingModel.UserBindingModel;
import com.teamproject.bet4life.models.Role;
import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.repositories.base.RoleRepository;
import com.teamproject.bet4life.services.base.RoleService;
import com.teamproject.bet4life.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private RoleService roleService;

    @Autowired
    public UserController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("view", "user/register");

        return "base-layout";
    }

    /*
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("view", "user/register");
        return "user/register";
    }

    @PostMapping("/register")
    public String registerProcess(UserBindingModel userBindingModel) {
        if (!userBindingModel.getPassword().equals(userBindingModel.getConfirmPassword())) {
            return "redirect:/register";
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


        User user = new User(
                userBindingModel.getUsername(),
                bCryptPasswordEncoder.encode(userBindingModel.getPassword())
        );

        service.registerUser(user);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("view", "user/loginn");
        return "user/loginn";
    }

    @GetMapping("all")
    List<User> getAllUsers(){
        List<User> sad = services.getAllUsers();
        System.out.println(sad);

        return sad;
    }

    @GetMapping("/id/{id}")
    public User getUserByID(@PathVariable String id) {
        User u = services.getUserByID(Integer.parseInt(id));
        System.out.println(u);

        return u;
    }

    public UserService getService() {
        return services;
    }

    public void setService(UserService services) {
        this.services = services;
    }

    */
}
