package com.TCPGroup.project.Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UserTest {

    private User user;

    @Before
    public void setup(){
        this.user = new User();
    }

    @Test
    public void getPassword() {
        String actual=this.user.getPassword();
        Assert.assertNull(actual);
    }

    @Test
    public void setPassword() {
        String expected="password";
        this.user.setPassword(expected);
        String actual = this.user.getPassword();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getId() {
        Integer expected=2;
       this.user = new User(expected);
        Integer actual=this.user.getId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getIdNull() {
        Assert.assertNull(this.user.getId());
    }

    @Test
    public void setId() {
        Integer expected =1;
        this.user.setId(expected);
        Integer actual = this.user.getId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getUserNameNull() {
        Assert.assertNull(this.user.getUsername());
    }

    @Test
    public void setUserName() {
        String expected = "username";
        this.user.setUsername(expected);
        String actual = this.user.getUsername();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAuthenticated() {
        Assert.assertNull(this.user.getAuthenticated());
    }

    @Test
    public void setAuthenticated() {
        Boolean expected =false;
        this.user.setAuthenticated(expected);
        Boolean actual = this.user.getAuthenticated();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getSubscriptionsNull() {
        User user=new User();
        List<Subscription> list = user.getSubscriptions();
        Assert.assertNull(list);
    }

    @Test
    public void setSubscriptions() {
        List<Subscription> expected = Arrays.asList(new Subscription(),new Subscription());
        User user = new User();
        user.setSubscriptions(expected);
        List<Subscription> actual = user.getSubscriptions();
        Assert.assertEquals(expected,actual);
    }
}