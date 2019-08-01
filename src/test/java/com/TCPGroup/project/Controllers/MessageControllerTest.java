package com.TCPGroup.project.Controllers;

import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Repositories.MessageRepository;
import com.TCPGroup.project.Services.MessageService;
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
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;


    @Test
    public void getMessagesByChannelId() {
        when(messageController.getMessagesByChannelId(1)).thenReturn(subData());
        messageController.getMessagesByChannelId(1);
        verify(messageService, times(1)).getMessageByChannel(1);
    }


    @Test
    public void postMessage() {
        Message message= createMessageMock();
        when( messageController.postMessage(message)).thenReturn(message);
        messageController.postMessage(message);
        verify(messageService, times(1)).postMessage(message);
    }

    private List<Message> subData() {return Arrays.asList(new Message(), new Message());}

    private Message createMessageMock(){return new Message ();}
}

