package com.TCPGroup.project.Services;

import com.TCPGroup.project.Models.Subscription;
import com.TCPGroup.project.Repositories.SubscriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SubscriptionServiceTest {

    @Mock
    private SubscriptionRepository subscriptionRepository;

    @InjectMocks
    private SubscriptionService subscriptionService;

    @Test
    public void getSubscriptionsByUserId() {
        when(subscriptionService.getSubscriptionsByUserId(2)).thenReturn(subscriptionList());
        subscriptionService.getSubscriptionsByUserId(2);
        verify(subscriptionRepository,times(1)).findByUserId(2);
    }

    @Test
    public void getSubscriptionsByChannelId() {
        when(subscriptionService.getSubscriptionsByChannelId(2)).thenReturn(subscriptionList());
        subscriptionService.getSubscriptionsByChannelId(2);
        verify(subscriptionRepository,times(1)).findByChannelId(2);
    }

    @Test
    public void createSubscription() {
        Subscription subscription=createMock();
        when(subscriptionService.createSubscription(subscription)).thenReturn(subscription);
        subscriptionService.createSubscription(subscription);
        verify(subscriptionRepository,times(1)).save(subscription);
    }

    @Test
    public void createSubscriptions() {
        List<Subscription> subscriptions=subscriptionList();
        when(subscriptionService.createSubscriptions(subscriptions)).thenReturn(subscriptions);
        subscriptionService.createSubscriptions(subscriptions);
        verify(subscriptionRepository,times(1)).saveAll(subscriptions);
    }

    private Subscription createMock(){
        return new Subscription();
    }

    private List<Subscription> subscriptionList(){
        Subscription sub1 = new Subscription();
        sub1.setUserId(1);
        Subscription sub2 = new Subscription();
        sub2.setUserId(2);
        return Arrays.asList(sub1,sub2);
    }
}