package com.TCPGroup.project.Services;


import com.TCPGroup.project.Models.Channel;
import com.TCPGroup.project.Models.Subscription;
import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ChannelService {


    private ChannelRepository channelRepository;
    private SubscriptionService subscriptionService;

    @Autowired
    public ChannelService(ChannelRepository channelRepository, SubscriptionService subscriptionService){
        this.channelRepository=channelRepository;
        this.subscriptionService=subscriptionService;
    }

    public List<Channel> getAllChannels(){
        return channelRepository.findAll();
    }

    public Channel getChannelById(Integer id){
        return channelRepository.getById(id);
    }

//    public List<User> getUsersByChannelId(Integer setChannelId){
//        List<User> users = new ArrayList<>();
//        List<Subscription> subs = this.subscriptionService.getSubscriptionsByChannelId(setChannelId);
//        for(Subscription sub:subs) users.add(sub.getUser());
//        return users;
//    }

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

    public List<Integer> getChannelIdsByUserId(Integer userId){
        List<Integer> channelIds = new ArrayList<>();
        List<Subscription> subs = this.subscriptionService.getSubscriptionsByUserId(userId);
        for(Subscription sub:subs) channelIds.add(sub.getChannelId());
        return channelIds;
    }

    public List<Channel> getChannelsByUserId(Integer userId){
        return this.getChannelsByIds(this.getChannelIdsByUserId(userId));
    }

    public Channel createDirectChannel(Integer id1, Integer id2){
        Channel direct = new Channel();
        direct.setDirect(true);
        direct.setName("@direct");
        // make the name a hash of the two userIds in natural order;
        // alternatively, create a new column that has "composite key" annotation between two userIds for direcct, and creatorID+channel name for standard

        direct = this.channelRepository.save(direct);

        Subscription sub1=new Subscription();
        sub1.setUserId(id1);
        sub1.setChannelId(direct.getId());
        sub1 = this.subscriptionService.createSubscription(sub1);

        Subscription sub2 = new Subscription();
        sub2.setUserId(id2);
        sub2.setChannelId(direct.getId());
        sub2= this.subscriptionService.createSubscription(sub2);

        direct.setSubscriptions(Arrays.asList(sub1, sub2));
        return direct;
    }
}
