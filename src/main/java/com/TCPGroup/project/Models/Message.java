package com.TCPGroup.project.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer fromUserId;
    private Integer toChannelId;
    private String body;
    private String fromUsername;

    public Message() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToChannelId() {
        return toChannelId;
    }

    public void setToChannelId(Integer toChannelId) {
        this.toChannelId = toChannelId;
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
