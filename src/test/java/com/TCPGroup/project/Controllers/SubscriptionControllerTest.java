package com.TCPGroup.project.Controllers;

import com.TCPGroup.project.Models.Subscription;
import com.TCPGroup.project.Services.SubscriptionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SubscriptionControllerTest {

    @Mock
    private SubscriptionService subscriptionService;

    @InjectMocks
    private SubscriptionController subscriptionController;

    @Test
    public void getSubscriptionsByUserId() {
        when(subscriptionController.getSubscriptionsByUserId(2)).thenReturn(subscriptionList());
        subscriptionController.getSubscriptionsByUserId(2);
        verify(subscriptionService,times(1)).getSubscriptionsByUserId(2);
    }

    @Test
    public void getSubscriptionsByChannelId() {
        when(subscriptionController.getSubscriptionsByChannelId(2)).thenReturn(subscriptionList());
        subscriptionController.getSubscriptionsByChannelId(2);
        verify(subscriptionService,times(1)).getSubscriptionsByChannelId(2);
    }

    @Test
    public void createNewSubscription() {
        Subscription subscription = createMock();
        when(subscriptionController.createNewSubscription(subscription)).thenReturn(subscription);
        subscriptionController.createNewSubscription(subscription);
        verify(subscriptionService,times(1)).createSubscription(subscription);
    }

    @Test
    public void createNewSubscriptions() {
        List<Subscription> subscriptions = subscriptionList();
        when(subscriptionController.createNewSubscriptions(subscriptions)).thenReturn(subscriptions);
        subscriptionController.createNewSubscriptions(subscriptions);
        verify(subscriptionService,times(1)).createSubscriptions(subscriptions);
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