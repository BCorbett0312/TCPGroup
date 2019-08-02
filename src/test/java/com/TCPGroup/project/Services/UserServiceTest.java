package com.TCPGroup.project.Services;

import com.TCPGroup.project.Models.Subscription;
import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private SubscriptionService subscriptionService;

    @InjectMocks
    private UserService userService;

    @Test
    public void getAllUsers() {
        when(userService.getAllUsers()).thenReturn(subData());
        userService.getAllUsers();
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void getById() {
        User user = createUserMock();
        when(userService.getById(2)).thenReturn(user);
        userService.getById(2);
        verify(userRepository, times(1)).getById(2);
    }

    @Test
    public void authenticateUser() {
        User user = createUserMock();
        when(userService.authenticateUser(user)).thenReturn(user);
        userService.authenticateUser(user);
        verify(userRepository, times(1)).findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Test
    public void createUser() {
        User user = createUserMock();
        when(userService.createUser(user)).thenReturn(user);
        userService.createUser(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void getUsersByIds() {
        List<User> users = subData();
        List<Integer> ids = Arrays.asList(1,2);
        when(userService.getUsersByIds(ids)).thenReturn(users);
        userService.getUsersByIds(ids);
        verify(userRepository, times(1)).findAllByIdIn(ids);
    }

    @Test
    public void getUserIdsByChannelId() {
        List<Integer> ids = Arrays.asList(1,2);
        when(userService.getUserIdsByChannelId(2)).thenReturn(ids);
        when(subscriptionService.getSubscriptionsByChannelId(2)).thenReturn(subscriptionList());
        userService.getUserIdsByChannelId(2);
        verify(subscriptionService, times(1)).getSubscriptionsByChannelId(2);
    }

    @Test
    public void getUsersByChannelId() {
        List<User> users = subData();
        List<Integer> ids = Arrays.asList(1,2);
        when(userService.getUsersByChannelId(2)).thenReturn(users);
        when(subscriptionService.getSubscriptionsByChannelId(2)).thenReturn(subscriptionList());
        userService.getUsersByChannelId(2);
    //    verify(userRepository, times(1)).findAllByIdIn(ids);
        verify(subscriptionService, times(2)).getSubscriptionsByChannelId(2);
    }


    private List<User> subData() {return Arrays.asList(new User(), new User());}

    private User createUserMock(){
        User user = new User();
        user.setUsername("test");
        return user;}

    private List<Subscription> subscriptionList(){
        Subscription sub1 = new Subscription();
        sub1.setUserId(1);
        Subscription sub2 = new Subscription();
        sub2.setUserId(2);
        return Arrays.asList(sub1,sub2);
    }
}