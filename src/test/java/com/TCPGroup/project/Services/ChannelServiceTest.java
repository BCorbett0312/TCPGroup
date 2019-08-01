package com.TCPGroup.project.Services;

import com.TCPGroup.project.Models.Channel;
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
    }

    @Test
    public void getChannelIdsByUserId() {
    }

    @Test
    public void getChannelsByUserId() {
    }

    @Test
    public void createDirectChannel() {
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