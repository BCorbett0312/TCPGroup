package com.TCPGroup.project.Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubscriptionTest {

    private Subscription subscription;

    @Before
    public void setup(){
        this.subscription=new Subscription();
    }

    @Test
    public void getId() {
        Integer expected=null;
        Integer actual=this.subscription.getId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setId() {
        Integer expected=5;
        this.subscription.setId(expected);
        Integer actual = this.subscription.getId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getUserId() {
    }

    @Test
    public void setUserId() {
    }

    @Test
    public void getChannelId() {
    }

    @Test
    public void setChannelId() {
    }
}