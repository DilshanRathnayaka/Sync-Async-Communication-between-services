package com.communication.communication.listners;

import com.communication.communication.events.UserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LogListener {
    @EventListener
    public void listen(UserEvent userEvent){
        System.out.println("UserEvent: " + userEvent.getUserId());
    }
}
