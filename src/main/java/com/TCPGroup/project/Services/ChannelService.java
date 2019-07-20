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

    public ChannelService(ChannelRepository channelRepository){
        this.channelRepository=channelRepository;

    }

    public List<Channel> getAllChannels(){
        return channelRepository.findAll();
    }

    public Channel getChannelById(Integer id){

        return channelRepository.getById(id);
    }

    public List<User> getUsersByChannelId(Integer channelId){
        List<User> users = new ArrayList<>();
        List<Subscription> subs = this.subscriptionService.getSubscriptionsByChannelId(channelId);
        for(Subscription sub:subs) users.add(sub.getUser());
        return users;
    }

}
