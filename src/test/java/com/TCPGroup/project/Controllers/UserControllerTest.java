package com.TCPGroup.project.Controllers;

import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Test
    public void getAllUsers() {
        when(userController.getAllUsers()).thenReturn(subData());
        userController.getAllUsers();
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void getUserById() {
        User user = createUserMock();
        when(userController.getUserById(1)).thenReturn(subData().get(1));
        userController.getUserById(1);
        //   verify(user, times(1)).getOne(1);
    }

    @Test
    public void authenticateUser() {
    }

    @Test
    public void createNewUser() {
    }



    private List<User> subData() {return Arrays.asList(new User(), new User());}

    private User createUserMock(){return new User ();}
}

