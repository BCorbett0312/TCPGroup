package com.TCPGroup.project.Services;

import com.TCPGroup.project.Models.Channel;
import com.TCPGroup.project.Models.Subscription;
import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubscriptionService subscriptionService;

    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getById(Integer id){
        return this.userRepository.getById(id);
    }

    public User authenticateUser(String userName, String password) {
        return userRepository.authenticateUser(userName, password);
    }

    public User createUser(User user){
        System.out.println(user);
        return userRepository.save(user);
    }

    public List<Channel> getChannelsByUserId(Integer userId){
        List<Channel> channels = new ArrayList<>();
        List<Subscription> subs = this.subscriptionService.getSubscriptionsByUserId(userId);
        for(Subscription sub:subs) channels.add(sub.getChannel());
        return channels;
    }
}