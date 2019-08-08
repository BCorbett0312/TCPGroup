package com.TCPGroup.project.Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ChannelTest {

    private Channel channel;

    @Before
    public void setup(){
        this.channel=new Channel();
    }

    @Test
    public void getId() {
    }

    @Test
    public void setId() {
    }

    @Test
    public void getName() {
        String expected=null;
        String actual=this.channel.getName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setName() {
    }

    @Test
    public void isDirect() {
        Assert.assertFalse(this.channel.isDirect());
    }

    @Test
    public void setDirect() {
    }

    @Test
    public void getSubscriptions() {
        List<Subscription> expected=null;
        List<Subscription> actual = this.channel.getSubscriptions();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setSubscriptions() {
        List<Subscription> expected = Arrays.asList(new Subscription(),new Subscription());
        this.channel.setSubscriptions(expected);
        List<Subscription> actual = this.channel.getSubscriptions();
        Assert.assertEquals(expected,actual);
    }
}