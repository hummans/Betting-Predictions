package com.teamproject.bet4life.controller;

import com.teamproject.bet4life.model.User;
import com.teamproject.bet4life.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("all")
    List<User> getAllUsers(){
        List<User> sad = service.getAllUsers();
        System.out.println(sad);

        return sad;
    }

    @GetMapping("/id/{id}")
    public User getUserByID(@PathVariable String id) {
        System.out.println("SAD: " + id);
        User u = service.getUserByID(Integer.parseInt(id));
        System.out.println("BLYAT");
        System.out.println(u);

        return u;
    }

   /* @PostMapping("register-user")
    public String newUser(@RequestParam String username, @RequestParam String pass){

        User u = new User();

        u.setDisplayName("sad");

        u.setPass("123asd");

        u.setEmail("wat@abv.bg");

        if(service.registerUser(u)){
            return "redirect:/all";
        }

        return "redirect:/register";
    }
    */
    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
        this.service = service;
    }

}
