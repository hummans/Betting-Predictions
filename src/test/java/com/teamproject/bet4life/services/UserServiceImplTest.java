package com.teamproject.bet4life.services;

import com.teamproject.bet4life.models.User;
import com.teamproject.bet4life.repositories.base.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private
    UserRepository mockRepository;

    @InjectMocks
    private
    UserServiceImpl service;

    @Test
    public void getAllUsers_Return_AllUsers() {
        when(mockRepository.getAllUsers())
                .thenReturn(Arrays.asList(
                        new User("MockUser1", "Mocky One", "MockPass1"),
                        new User("MockUser2", "Mocky Two", "MockPass2"),
                        new User("MockUser3", "Mocky Three", "MockPass3")
                ));

        List<User> result = service.getAllUsers();

        Assert.assertEquals(3, result.size());
    }

    @Test
    public void getUserByID_Return_UserWithSameID() {
        when(mockRepository.getUserByID(1))
                .thenReturn(new User("MockUser", "Mocky Mock", "MockPass"));

        User result = service.getUserByID(1);

        Assert.assertEquals("MockUser", result.getUsername());

    }

    @Test
    public void findByUsername_Return_UserWithSameUsername() {
        when(mockRepository.findByUsername("MockUser"))
                .thenReturn(new User("MockUser", "Mocky Mock", "MockPass"));

        User result = service.findByUsername("MockUser");

        Assert.assertEquals("MockUser", result.getUsername());
    }

    @Test
    public void registerUser() {
    }
}