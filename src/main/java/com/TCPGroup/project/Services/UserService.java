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
    private ChannelService channelService;

    @Autowired
    public UserService(UserRepository userRepository, SubscriptionService subscriptionService, ChannelService channelService) {
        this.userRepository=userRepository;
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

    public List<Integer> getChannelIdsByUserId(Integer userId){
        List<Integer> channelIds = new ArrayList<>();
        List<Subscription> subs = this.subscriptionService.getSubscriptionsByUserId(userId);
        for(Subscription sub:subs) channelIds.add(sub.getChannelId());
        return channelIds;
    }

    public List<User> getUsersByIds(List<Integer> ids){
        return this.userRepository.findAllByIdIn(ids);
    }

    public List<Channel> getChannelsByUserId(Integer userId){
        return this.channelService.getChannelsByIds(this.getChannelIdsByUserId(userId));
    }
}