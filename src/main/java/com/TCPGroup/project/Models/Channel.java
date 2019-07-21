package com.TCPGroup.project.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private boolean direct;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "channel")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "channelId")
    private List<Subscription> subscriptions;

    public Channel(){ }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDirect() {
        return direct;
    }

    public void setDirect(boolean direct) {
        this.direct = direct;
    }

    public List<Subscription> getSubscriptions() { return subscriptions; }

    public void setSubscriptions(List<Subscription> subscriptions) { this.subscriptions = subscriptions; }
}
