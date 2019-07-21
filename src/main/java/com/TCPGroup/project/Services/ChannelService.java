package com.TCPGroup.project.Services;


import com.TCPGroup.project.Models.Channel;
import com.TCPGroup.project.Models.Subscription;
import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {
    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    UserService userService;

    public ChannelService(ChannelRepository channelRepository){
        this.channelRepository=channelRepository;
    }

    public List<Channel> getAllChannels(){
        return channelRepository.findAll();
    }

    public Channel getChannelById(Integer id){
        return channelRepository.getById(id);
    }

//    public List<User> getUsersByChannelId(Integer channelId){
//        List<User> users = new ArrayList<>();
//        List<Subscription> subs = this.subscriptionService.getSubscriptionsByChannelId(channelId);
//        for(Subscription sub:subs) users.add(sub.getUser());
//        return users;
//    }
    public List<Integer> getUserIdsByChannelId(Integer channelId){
        List<Integer> userIds = new ArrayList<>();
        List<Subscription> subs = this.subscriptionService.getSubscriptionsByChannelId(channelId);
        for(Subscription sub:subs) userIds.add(sub.getUserId());
        return userIds;
    }

    public Channel createChannel(Channel channel){
        System.out.println(channel);
        return this.channelRepository.save(channel);
    }

    public List<Channel> getStandardChannels(){
        return this.channelRepository.findAllByDirectFalse();
    }

    public List<Channel> getChannelsByIds(List<Integer> ids){
        return this.channelRepository.findAllByIdIn(ids);
    }

    public List<User> getUsersByChannelId(Integer channelId){
        return this.userService.getUsersByIds(this.getUserIdsByChannelId(channelId));
    }
}
