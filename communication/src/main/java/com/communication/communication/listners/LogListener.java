package com.communication.communication.listners;

import com.communication.communication.events.UserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LogListener {
    @EventListener
    @Async
    @Order(2)
    public void listen(UserEvent userEvent){
        System.out.println("UserEvent: " + userEvent.getUserId());
        throw new RuntimeException("UserEvent:error ");
    }
}
