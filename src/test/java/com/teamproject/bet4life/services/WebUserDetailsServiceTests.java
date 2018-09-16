package com.teamproject.bet4life.services;

import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.repositories.base.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebUserDetailsServiceTests {
    @Mock
    private UserRepository mockUserRepository;

    private WebUserDetailsService webUserDetailsService;

    private final String noSuchUsername = "testuser100";

    @Before
    public void beforeTest() {
        webUserDetailsService = new WebUserDetailsService(mockUserRepository);
    }

    @Test
    public void loadUserByUsername_shouldReturnUserDetails_whenSuchUserExists() {
        //Arrange
        User user = new User("mockUser", "user user", "pass");

        Set<GrantedAuthority> grantedAuthorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        org.springframework.security.core.userdetails.User userToFind =
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        grantedAuthorities
                );

        when(mockUserRepository.findByUsername("mockUser")).thenReturn(user);

        // ACT
        UserDetails userFound = webUserDetailsService.loadUserByUsername("sdljk");

        // ASSERT
        Assert.assertEquals(userToFind, userFound);
    }
}
