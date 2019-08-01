package com.TCPGroup.project.Services;

import com.TCPGroup.project.Models.Message;
import com.TCPGroup.project.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;
    private UserService userService;

    List<Message> messageList;
    Comparator<Message> compareById = Comparator.comparing(Message::getId);


    @Autowired
    public MessageService(MessageRepository messageRepository, UserService userService){
        this.messageRepository=messageRepository;
        this.userService=userService;
    }

    public List<Message> getMessageByChannel(Integer toChannelId){
        List<Message> messageList;
        Comparator<Message> compareById = Comparator.comparing(Message::getId);
        messageList = messageRepository.getMessagesByChannelId(toChannelId);
        for(Message message:messageList){
            message.setFromUsername(this.userService.getById(message.getUserId()).getUsername());
        }
        Collections.sort(messageList, compareById.reversed());
        return messageList;
    }

    public Message postMessage(Message message){
        String[] words=message.getBody().split("\"");
        message.setBody(String.join("\\\"",words));
        return messageRepository.save(message);
    }



}
