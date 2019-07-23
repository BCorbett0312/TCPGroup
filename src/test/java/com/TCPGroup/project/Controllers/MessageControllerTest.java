package com.TCPGroup.project.Controllers;

import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Repositories.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.TCPGroup.project.Models.Message;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class MessageControllerTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageController messageController;


    @Test
    public void getMessagesByChannelId() {
        Message message= createMessageMock();
        when(messageController.getMessagesByChannelId(1)).thenReturn((List<Message>) subData().get(1));
        messageController.getMessagesByChannelId(1);
    }


    @Test
    public void postMessage() {
        Message message= createMessageMock();
        when( messageController.postMessage(message)).thenReturn(message);
        messageController.postMessage(message);
    }

    private List<Message> subData() {return Arrays.asList(new Message(), new Message());}

    private Message createMessageMock(){return new Message ();}
}

