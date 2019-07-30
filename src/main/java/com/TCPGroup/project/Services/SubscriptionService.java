package com.TCPGroup.project.Services;

import com.TCPGroup.project.Models.Subscription;
import com.TCPGroup.project.Repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    private SubscriptionRepository subscriptionRepository;

    @Autowired
    SubscriptionService(SubscriptionRepository subscriptionRepository){
        this.subscriptionRepository=subscriptionRepository;
    }

    public List<Subscription> getSubscriptionsByUserId(Integer userId){
        return this.subscriptionRepository.findByUserId(userId);
    }

    public List<Subscription> getSubscriptionsByChannelId(Integer channelId){
        return this.subscriptionRepository.findByChannelId(channelId);
    }

    public Subscription createSubscription(Subscription subscription){
        return this.subscriptionRepository.save(subscription);
    }

    public List<Subscription> createSubscriptions(List<Subscription> subscriptions){
        return this.subscriptionRepository.saveAll(subscriptions);
    }
}
