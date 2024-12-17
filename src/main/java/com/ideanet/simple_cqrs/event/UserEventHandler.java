package com.ideanet.simple_cqrs.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {

    @EventListener
    public void onUserCreated(UserCreatedEvent event) {
        System.out.println("UserCreatedWithID: " + event.getId());
        System.out.println("UserCreatedWithName: " + event.getName());
        System.out.println("UserCreatedWithEmail: " + event.getEmail());
    }
}
