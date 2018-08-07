package com.teamproject.bet4life.controller;

import com.teamproject.bet4life.bindingModels.UserBindingModel;
import com.teamproject.bet4life.models.Role;
import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.services.base.RoleService;
import com.teamproject.bet4life.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public String register(Model model) {
        model.addAttribute("view", "user/register");

        return "base-layout";
    }

    @PostMapping("/register")
    public String registerProcess(UserBindingModel userBindingModel) {
        // check if password matches
        if (!userBindingModel.getPassword().equals(userBindingModel.getConfirmPassword())) {
            return "redirect:/register";
        }

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
