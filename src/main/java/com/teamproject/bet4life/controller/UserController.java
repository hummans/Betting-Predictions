package com.teamproject.bet4life.controller;

import com.teamproject.bet4life.bindingModels.UserBindingModel;
import com.teamproject.bet4life.models.Prediction;
import com.teamproject.bet4life.models.Role;
import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.services.base.RoleService;
import com.teamproject.bet4life.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/register")
    public String register(Model model, @ModelAttribute UserBindingModel userBindingModel) {
        model.addAttribute("view", "user/register");

        return "base-layout";
    }

    @PostMapping("/register")
    public String registerProcess(@Valid @ModelAttribute("userBindingModel")  UserBindingModel userBindingModel, BindingResult bindingResult, Model model) {
        // check if password matches
        if (bindingResult.hasErrors()) {

            model.addAttribute("view", "user/register");

            return "base-layout";
        }

        /*
        if (!userBindingModel.getPassword().equals(userBindingModel.getConfirmPassword())) {
            return "redirect:/register";
        }
        */

        // encode password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        // create user instance
        User user = new User(
                userBindingModel.getUsername(),
                userBindingModel.getFullname(),
                bCryptPasswordEncoder.encode(userBindingModel.getPassword())
        );

        // assign role
        Role userRole = this.roleService.findByName("ROLE_USER");
        user.addRole(userRole);

        userService.registerUser(user);

        return "redirect:/login";
    }


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("view", "user/login");
        return "base-layout";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login?logout";
    }

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String profilePage(Model model) {
        // get currently logged in user
        UserDetails principal =
                (UserDetails) SecurityContextHolder.getContext()
                                                   .getAuthentication()
                                                    .getPrincipal();

        User user = this.userService.findByUsername(principal.getUsername());

        // add user to model
        model.addAttribute("user", user);

        // return the view
        model.addAttribute("view", "user/profile");
        return "base-layout";
    }

    @GetMapping("/user/user-predictions")
    @PreAuthorize("isAuthenticated()")
    public String myPredictions(Model model) {
        // get currently logged in user
        UserDetails principal =
                (UserDetails) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal();

        User user = this.userService.findByUsername(principal.getUsername());

        // get predictions
        List<Prediction> userPredictions = user.getPredictions().stream()
                .sorted((a,b) -> b.getDate().compareTo(a.getDate()))
                .collect(Collectors.toList());

        // add predictions to model
        model.addAttribute("userPredictions", userPredictions);

        model.addAttribute("user", user);

        // return the view
        model.addAttribute("view", "user/user-predictions");
        return "base-layout";
    }

    @RequestMapping("/user/view/{id}")
    public String viewUser(@PathVariable("id") int id, Model model) {
        User user = this.userService.getUserByID(id);
        model.addAttribute("user", user);

        model.addAttribute("view", "user/profile");
        return "base-layout";
    }
    /*
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
