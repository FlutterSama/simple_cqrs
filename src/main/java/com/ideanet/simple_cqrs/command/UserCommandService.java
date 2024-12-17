package com.ideanet.simple_cqrs.command;

import com.ideanet.simple_cqrs.domain.User;
import com.ideanet.simple_cqrs.event.UserCreatedEvent;
import com.ideanet.simple_cqrs.repository.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
//bad practice, use Interface (i dont bc this is just test)
public class UserCommandService {

    private final UserRepository userRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public UserCommandService(UserRepository userRepository,ApplicationEventPublisher applicationEventPublisher) {
        this.userRepository = userRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Long handle(CreateUserCommand command) {
        User user = new User();
        user.setName(command.getName());
        user.setEmail(command.getEmail());

        user = userRepository.save(user);

        UserCreatedEvent event = new UserCreatedEvent(user.getId(), user.getName(), user.getEmail());
        applicationEventPublisher.publishEvent(event);
        return user.getId();
    }

}
