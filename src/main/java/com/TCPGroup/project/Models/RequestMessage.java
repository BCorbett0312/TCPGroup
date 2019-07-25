package com.TCPGroup.project.Models;

public class RequestMessage {

    private Integer fromUserId;
    private Integer toChannelId;
    private String body;
    private String fromUsername;

    public RequestMessage() {
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

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }
}
