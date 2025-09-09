package com.communication.communication.listners;

import com.communication.communication.events.UserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEmailListener {
    @EventListener
    public void handleUserEvent(UserEvent userEvent){
        System.out.println("Received UserEvent: " + userEvent.getUserId());
    }
}
