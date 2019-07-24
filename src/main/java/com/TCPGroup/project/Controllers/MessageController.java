package com.TCPGroup.project.Controllers;

import com.TCPGroup.project.Models.Message;
import com.TCPGroup.project.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MessageController {


    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService){
        this.messageService=messageService;
    }


    @GetMapping("/messages/{channelId}")
    public List<Message> getMessagesByChannelId(@PathVariable Integer channelId){
        return messageService.getMessageByChannel(channelId);
    }

    @PostMapping("/messages")
    public Message postMessage(@RequestBody Message message){
        return messageService.postMessage(message);
    }


}
