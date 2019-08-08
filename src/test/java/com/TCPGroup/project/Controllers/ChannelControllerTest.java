package com.TCPGroup.project.Controllers;

import com.TCPGroup.project.Models.Channel;
import com.TCPGroup.project.Services.ChannelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ChannelControllerTest {

    @Mock
    ChannelService channelService;

    @InjectMocks
    ChannelController channelController;

    @Test
    public void getAllChannels() {
        when(channelController.getAllChannels()).thenReturn(channelList());
        channelController.getAllChannels();
        verify(channelService,times(1)).getAllChannels();
    }

    @Test
    public void getChannelById() {
        when(channelController.getChannelById(2)).thenReturn(channelMock());
        channelController.getChannelById(2);
        verify(channelService,times(1)).getChannelById(2);
    }

    @Test
    public void getChannelIdsByUserId() {
        when(channelController.getChannelIdsByUserId(2)).thenReturn(Arrays.asList(1,2,3));
        channelController.getChannelIdsByUserId(2);
        verify(channelService,times(1)).getChannelIdsByUserId(2);
    }

    @Test
    public void getChannelsByUserId() {
        when(channelController.getChannelsByUserId(2)).thenReturn(channelList());
        channelController.getChannelsByUserId(2);
        verify(channelService,times(1)).getChannelsByUserId(2);
    }

    @Test
    public void createNewChannel() {
        Channel channel = channelMock();
        when(channelController.createNewChannel(channel)).thenReturn(channel);
        channelController.createNewChannel(channel);
        verify(channelService,times(1)).createChannel(channel);
    }

    @Test
    public void getStandardChannels() {
        when(channelController.getStandardChannels()).thenReturn(channelList());
        channelController.getStandardChannels();
        verify(channelService,times(1)).getStandardChannels();
    }

    @Test
    public void createDirectChannel() {
        Channel channel = channelMock();
        when(channelController.findDirectChannel(2,3)).thenReturn(channel);
        channelController.findDirectChannel(2,3);
        verify(channelService,times(1)).createDirectChannel(2,3);
    }

    private Channel channelMock(){
        return new Channel();
    }

    private List<Channel> channelList(){
        Channel chan1 = new Channel();
        Channel chan2 = new Channel();
        return Arrays.asList(chan1,chan2);
    }
}