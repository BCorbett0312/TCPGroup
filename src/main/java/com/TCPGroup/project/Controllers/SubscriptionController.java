package com.TCPGroup.project.Controllers;

import com.TCPGroup.project.Models.Subscription;
import com.TCPGroup.project.Services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService=subscriptionService;
    }

    @GetMapping("/users/{userId}/subscriptions")
    public List<Subscription> getSubscriptionsByUserId(@PathVariable Integer userId){
        return this.subscriptionService.getSubscriptionsByUserId(userId);
    }

    @GetMapping("/channels/{channelId}/subscriptions")
    public List<Subscription> getSubscriptionsByChannelId(@PathVariable Integer channelId){
        return this.subscriptionService.getSubscriptionsByChannelId(channelId);
    }

    @PostMapping("/subscriptions")
    public Subscription createNewSubscription(@RequestBody Subscription newSubscription){
        return this.subscriptionService.createSubscription(newSubscription);
    }

    @PostMapping("/subscriptions/list")
    public List<Subscription> createNewSubscription(@RequestBody List<Subscription> subscriptions){
        return this.subscriptionService.createSubscriptions(subscriptions);
    }

}
