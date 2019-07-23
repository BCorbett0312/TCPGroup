package com.TCPGroup.project.Models;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @OneToOne
    private Integer userId;

//    @OneToOne
    private Integer channelId;

    private String body;

    @Transient
    private String fromUsername;

    public Message() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channel) {
        this.channelId = channel;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFromUsername() {return fromUsername;}

    public void setFromUsername(String fromUsername) {this.fromUsername = fromUsername;}
}
