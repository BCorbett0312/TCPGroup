package com.TCPGroup.project.Models;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User user;

    @OneToOne
    private Channel channel;

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

    public Integer getUser() {
        return user.getId();
    }

    public void setUser(User user) {
        this.user = user;
        this.fromUsername= user.getUsername();
    }

    public Integer getChannel() {
        return channel.getId();
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
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
