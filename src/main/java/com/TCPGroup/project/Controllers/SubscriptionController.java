package com.TCPGroup.project.Controllers;

import com.TCPGroup.project.Models.Subscription;
import com.TCPGroup.project.Services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService=subscriptionService;
    }

    public List<Subscription> getSubscriptionsByUserId(Integer userId){
        return this.subscriptionService.getSubscriptionsByUserId(userId);
    }

    public List<Subscription> getSubscriptionsByChannelId(Integer channelId){
        return this.subscriptionService.getSubscriptionsByChannelId(channelId);
    }
}
