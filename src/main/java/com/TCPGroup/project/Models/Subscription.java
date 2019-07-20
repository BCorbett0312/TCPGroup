package com.TCPGroup.project.Models;

import javax.persistence.*;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="SUBSCRIPTION_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(referencedColumnName="id")
    private User user;

    @ManyToOne
    @JoinColumn(referencedColumnName="id")
    private Channel channel;

    public Subscription() { }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Channel getChannel() { return channel; }

    public void setChannel(Channel channel) { this.channel = channel; }
}
