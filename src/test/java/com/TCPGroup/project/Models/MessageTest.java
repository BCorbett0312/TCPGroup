package com.TCPGroup.project.Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {

    private Message message;

    @Before
    public void setup() {
        this.message = new Message();
    }

    @Test
    public void getId() {
        Integer expected=null;
        Integer actual=message.getId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setId() {
        Integer expected=5;
        message.setId(expected);
        Integer actual=message.getId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getUserId() {
        Integer expected=null;
        Integer actual=message.getUserId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setUserId() {
        Integer expected=5;
        message.setUserId(expected);
        Integer actual=message.getUserId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getChannelId() {
        Integer expected=null;
        Integer actual=message.getChannelId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setChannelId() {
        Integer expected=5;
        message.setChannelId(expected);
        Integer actual=message.getChannelId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getBody() {
        String expected=null;
        String actual = message.getBody();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setBody() {
        String expected="abc";
        message.setBody(expected);
        String actual=message.getBody();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getFromUsername() {
        String expected=null;
        String actual = message.getFromUsername();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setFromUsername() {
        String expected="abc";
        message.setFromUsername(expected);
        String actual=message.getFromUsername();
        Assert.assertEquals(expected,actual);
    }
}