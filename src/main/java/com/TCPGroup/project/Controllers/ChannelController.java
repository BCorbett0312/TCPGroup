package com.TCPGroup.project.Controllers;


import com.TCPGroup.project.Models.Channel;
import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class
ChannelController {

    @Autowired
    ChannelService channelService;

    public ChannelController(ChannelService channelService){
        this.channelService = channelService;
    }

    @GetMapping("/channels")
    public List<Channel> getAllChannels(){
        return channelService.getAllChannels();
    }

    @GetMapping("/channels/{id}")
    public Channel getChannelById(@PathVariable Integer id){
        return channelService.getChannelById(id);
    }

    @GetMapping("/channels/{id}/userids")
    public List<Integer> getUserIdsByChannelId(@PathVariable Integer id){
        return this.channelService.getUserIdsByChannelId(id);
    }

    @GetMapping("/channels/{id}/users")
    public List<User> getUsersByChannelId(@PathVariable Integer id){
        return this.channelService.getUsersByChannelId(id);
    }

    @PostMapping("/channels")
    public Channel createNewChannel(@RequestBody Channel newChannel){
        return this.channelService.createChannel(newChannel);
    }

    @GetMapping("/channels/standard")
    public List<Channel> getStandardChannels(){
        return channelService.getStandardChannels();
    }

}
