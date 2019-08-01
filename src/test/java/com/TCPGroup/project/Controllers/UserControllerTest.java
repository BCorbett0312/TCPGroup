package com.TCPGroup.project.Controllers;

import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void getAllUsers() {
        when(userController.getAllUsers()).thenReturn(subData());
        userController.getAllUsers();
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    public void getUserById() {
        User user = createUserMock();
        when(userController.getUserById(2)).thenReturn(user);
        userController.getUserById(2);
        verify(userService, times(1)).getById(2);
    }

    @Test
    public void authenticateUser() {
        User user = createUserMock();
        when(userController.authenticateUser(user)).thenReturn(user);
        userController.authenticateUser(user);
        verify(userService, times(1)).authenticateUser(user);
    }

    @Test
    public void getUserIdsByChannelId() {
        List<Integer> ids = Arrays.asList(1,2);
        when(userController.getUserIdsByChannelId(2)).thenReturn(ids);
        userController.getUserIdsByChannelId(2);
        verify(userService, times(1)).getUserIdsByChannelId(2);
    }

    @Test
    public void getUsersByChannelId() {
        List<User> users = subData();
        when(userController.getUsersByChannelId(2)).thenReturn(users);
        userController.getUsersByChannelId(2);
        verify(userService,times(1)).getUsersByChannelId(2);
    }

    @Test
    public void createNewUser() {
        User user = createUserMock();
        when(userController.createNewUser(user)).thenReturn(user);
        userController.createNewUser(user);
        verify(userService, times(1)).createUser(user);
    }



    private List<User> subData() {return Arrays.asList(new User(), new User());}

    private User createUserMock(){return new User ();}

}

