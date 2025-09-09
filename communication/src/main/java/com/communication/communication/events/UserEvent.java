package com.communication.communication.events;

public class UserEvent {
    private final Integer userId;

    public UserEvent(Integer userId) {
        this.userId = userId;
    }
    public Integer getUserId() {
        return userId;
    }
}
