package com.communication.communication.listners;

import com.communication.communication.events.UserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserEmailListener {
    @EventListener
    @Async
    @Order(1)
    public void handleUserEvent(UserEvent userEvent){
        System.out.println("Received UserEvent: " + userEvent.getUserId());
    }
}
