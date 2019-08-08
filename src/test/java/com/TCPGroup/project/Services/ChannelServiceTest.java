package com.TCPGroup.project.Services;

import com.TCPGroup.project.Models.Channel;
import com.TCPGroup.project.Models.Subscription;
import com.TCPGroup.project.Repositories.ChannelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ChannelServiceTest {

    @Mock
    ChannelRepository channelRepository;

    @Mock
    SubscriptionService subscriptionService;

    @InjectMocks
    ChannelService channelService;

    @Test
    public void getAllChannels() {
        when(channelService.getAllChannels()).thenReturn(channelList());
        channelService.getAllChannels();
        verify(channelRepository,times(1)).findAll();
    }

    @Test
    public void getChannelById() {
        when(channelService.getChannelById(2)).thenReturn(channelMock());
        channelService.getChannelById(2);
        verify(channelRepository,times(1)).getById(2);
    }

    @Test
    public void createChannel() {
        Channel channel = channelMock();
        when(channelService.createChannel(channel)).thenReturn(channel);
        channelService.createChannel(channel);
        verify(channelRepository,times(1)).save(channel);
    }

    @Test
    public void getStandardChannels() {
        when(channelService.getStandardChannels()).thenReturn(channelList());
        channelService.getStandardChannels();
        verify(channelRepository,times(1)).findAllByDirectFalse();
    }

    @Test
    public void getChannelsByIds() {
        List<Integer> list = Arrays.asList(1,2,3);
        when(channelService.getChannelsByIds(list)).thenReturn(channelList());
        channelService.getChannelsByIds(list);
        verify(channelRepository,times(1)).findAllByIdIn(list);
    }

    @Test
    public void getChannelIdsByUserId() {
        List<Integer> ids = Arrays.asList(1,2);
        when(channelService.getChannelIdsByUserId(2)).thenReturn(ids);
        when(subscriptionService.getSubscriptionsByUserId(2)).thenReturn(subscriptionList());
        channelService.getChannelIdsByUserId(2);
        verify(subscriptionService,times(1)).getSubscriptionsByUserId(2);
    }

    @Test
    public void getChannelsByUserId() {
      //  List<Integer> ids = Arrays.asList(1,2);
        List<Channel> channels = channelList();
        when(channelService.getChannelsByUserId(2)).thenReturn(channels);
        when(subscriptionService.getSubscriptionsByChannelId(2)).thenReturn(subscriptionList());
        channelService.getChannelIdsByUserId(2);
        verify(subscriptionService,times(2)).getSubscriptionsByUserId(2);
    }

    @Test
    public void createDirectChannel() {
        Channel channel = channelMock();
        channel.setId(2);
        Integer user1=1;
        Subscription sub = new Subscription();
        sub.setUserId(user1);
        sub.setChannelId(channel.getId());
        when(channelService.createDirectChannel(user1,user1)).thenReturn(channel);
        when(channelRepository.save(channel)).thenReturn(channel);
        channelService.createDirectChannel(user1,user1);
        verify(channelRepository,times(1)).save(channel);
        verify(subscriptionService,times(2)).createSubscription(sub);
    }

    private Channel channelMock(){
        return new Channel();
    }

    private List<Channel> channelList(){
        Channel chan1 = new Channel();
        Channel chan2 = new Channel();
        return Arrays.asList(chan1,chan2);
    }

    private List<Subscription> subscriptionList(){
        Subscription sub1 = new Subscription();
        sub1.setChannelId(1);
        Subscription sub2 = new Subscription();
        sub2.setChannelId(2);
        return Arrays.asList(sub1,sub2);
    }
}