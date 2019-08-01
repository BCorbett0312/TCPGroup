package com.TCPGroup.project.Controllers;


import com.TCPGroup.project.Models.Channel;
import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ChannelController {


    private ChannelService channelService;

    @Autowired
    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("/channels")
    public List<Channel> getAllChannels() {
        return channelService.getAllChannels();
        //return new RensponseEntety
    }

    @GetMapping("/channels/{id}")
    public Channel getChannelById(@PathVariable Integer id) {
        return channelService.getChannelById(id);
    }


    @GetMapping("/users/{id}/channelids")
    public List<Integer> getChannelIdsByUserId(@PathVariable Integer id){
        return this.channelService.getChannelIdsByUserId(id);
    }

    @GetMapping("/users/{id}/channels")
    public List<Channel> getChannelsByUserId(@PathVariable Integer id){
        return this.channelService.getChannelsByUserId(id);
    }

    @PostMapping("/channels")
    public Channel createNewChannel(@RequestBody Channel newChannel){
        return this.channelService.createChannel(newChannel);
    }

    @GetMapping("/channels/standard")
    public List<Channel> getStandardChannels(){
        return channelService.getStandardChannels();
    }

    @GetMapping("/channels/{id1}/{id2}")
    public Channel createDirectChannel(@PathVariable Integer id1, @PathVariable Integer id2){
        return this.channelService.createDirectChannel(id1, id2);
    }

}
