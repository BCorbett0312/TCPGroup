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

    private UserRepository userRepository;
    private SubscriptionService subscriptionService;

    @Autowired
    public UserService(UserRepository userRepository, SubscriptionService subscriptionService) {
        this.userRepository=userRepository;
        this.subscriptionService=subscriptionService;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getById(Integer id){
        return this.userRepository.getById(id);
    }

    public User authenticateUser(User userToAuthenticate) {
        return userRepository.findByUsernameAndPassword(userToAuthenticate.getUsername(), userToAuthenticate.getPassword());
    }

    public User createUser(User user){
        return userRepository.save(user);
    }


    public List<User> getUsersByIds(List<Integer> ids){
        return this.userRepository.findAllByIdIn(ids);
    }

    public List<Integer> getUserIdsByChannelId(Integer channelId){
        List<Integer> userIds = new ArrayList<>();
        List<Subscription> subs = this.subscriptionService.getSubscriptionsByChannelId(channelId);
        for(Subscription sub:subs) userIds.add(sub.getUserId());
        return userIds;
    }

    public List<User> getUsersByChannelId(Integer channelId){
        return this.getUsersByIds(this.getUserIdsByChannelId(channelId));
    }
}