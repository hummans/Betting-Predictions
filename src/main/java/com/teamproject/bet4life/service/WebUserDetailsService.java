package com.teamproject.bet4life.service;


import com.teamproject.bet4life.model.User;
import com.teamproject.bet4life.repositories.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("webUserDetailsService")
public class WebUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public WebUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid user");
        } else {
            return new org
                    .springframework
                    .security
                    .core
                    .userdetails
                    .User(user.getUsername(),user.getPassword(),null);
        }
    }
}
