package com.TCPGroup.project.Services;

import com.TCPGroup.project.Models.Message;
import com.TCPGroup.project.Repositories.MessageRepository;
import com.TCPGroup.project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserService userService;

    List<Message> messageList;
    Comparator<Message> compareById = Comparator.comparing(Message::getId);


    MessageService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }

    public List<Message> getMessageByChannel(Integer toChannelId){
        messageList = messageRepository.getMessagesByChannelId(toChannelId);
        for(Message message:messageList){
            message.setFromUsername(this.userService.getById(message.getUserId()).getUsername());
        }
        Collections.sort(messageList, compareById.reversed());

        return messageList;
    }

    public Message postMessage(Message message){
        return messageRepository.save(message);
    }



}
