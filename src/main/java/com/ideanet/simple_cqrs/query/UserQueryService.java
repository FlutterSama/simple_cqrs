package com.ideanet.simple_cqrs.query;

import com.ideanet.simple_cqrs.domain.User;
import com.ideanet.simple_cqrs.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserQueryService {

    private final UserRepository userRepository;

    public UserQueryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserQueryResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->new RuntimeException("User not found"));
        return new UserQueryResponse(user.getId(), user.getName(), user.getEmail());
    }

}
