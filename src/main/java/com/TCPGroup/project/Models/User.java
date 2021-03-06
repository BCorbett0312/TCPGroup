package com.TCPGroup.project.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String password;
    private String username;

    @Transient
    private Boolean authenticated;

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    private List<Subscription> subscriptions;

    public User() {
        authenticated = null;
    }

    public User(Integer id) {
        authenticated = null;
        this.id=id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public List<Subscription> getSubscriptions() { return subscriptions; }

    public void setSubscriptions(List<Subscription> subscriptions) { this.subscriptions = subscriptions; }
}
