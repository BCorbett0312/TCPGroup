package com.TCPGroup.project.Services;

import com.TCPGroup.project.Models.Message;
import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Repositories.MessageRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private MessageService messageService;

    @Before
    public void setup(){
        this.messageService=new MessageService(this.messageRepository,this.userService);
    }

    @Test
    public void getMessageByChannel() {
        String username = "abc";
        Message message = createMessageMock();
        message.setFromUsername(username);
        User user = new User();
        user.setUsername(username);
        when(messageService.getMessageByChannel(2)).thenReturn(subData());
        when(this.userService.getById(message.getUserId())).thenReturn(user);
        when(messageRepository.getMessagesByChannelId(2)).thenReturn(subData());
        messageService.getMessageByChannel(2);
        verify(messageRepository,times(1)).getMessagesByChannelId(2);
    }

    @Test
    public void postMessage() {
        Message message = createMessageMock();
        when(messageService.postMessage(message)).thenReturn(message);
        messageService.postMessage(message);
        verify(messageRepository,times(1)).save(message);
    }

    private List<Message> subData() {
        Message m1=new Message();
        Message m2=new Message();
        m1.setBody("body");
        m2.setBody("body");
        m1.setId(1);
        m2.setId(2);
        return Arrays.asList(m1,m2);
    }

    private Message createMessageMock(){
        Message message = new Message();
        message.setBody("body");
        return message;
    }
}