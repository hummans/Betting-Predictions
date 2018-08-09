package com.teamproject.bet4life.bindingModels;

import com.teamproject.bet4life.annotations.IsPasswordMatching;
import com.teamproject.bet4life.annotations.IsUsernameUnique;
import com.teamproject.bet4life.services.UserServiceImpl;
import com.teamproject.bet4life.services.base.UserService;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@IsUsernameUnique(service = UserServiceImpl.class, fieldName = "username", message = "Username already exists.")
@IsPasswordMatching
public class UserBindingModel {

    @NotNull
    @Size(min = 3, message = "Username must be at least 3 chars")
    private String username;

    @NotNull
    private String fullname;

    @NotNull
    @Size(min = 5, message = "Password must be at least 5 chars")
    private String password;

    @NotNull
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
