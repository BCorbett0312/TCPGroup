package com.TCPGroup.project.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="SUBSCRIPTION_ID")
    private Integer id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(referencedColumnName="id")
//    private User user;
    private Integer userId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(referencedColumnName="id")
    private Integer channelId;

    public Subscription() { }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    //public User getUser() { return user; }

   // public void setUser(User user) { this.user = user; }

    public Integer getUserId() { return userId;  }

    public void setUserId(Integer user_id) {  this.userId = user_id; }
//
//    public Channel getChannel() { return channel; }
//
//    public void setChannel(Channel channel) { this.channel = channel; }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {this.channelId = channelId;
    }
}
