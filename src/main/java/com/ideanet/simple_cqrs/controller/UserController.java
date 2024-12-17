package com.ideanet.simple_cqrs.controller;

import com.ideanet.simple_cqrs.command.CreateUserCommand;
import com.ideanet.simple_cqrs.command.UserCommandService;
import com.ideanet.simple_cqrs.query.UserQueryResponse;
import com.ideanet.simple_cqrs.query.UserQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody CreateUserCommand command) {
        Long userId = userCommandService.handle(command);
        return ResponseEntity.ok(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserQueryResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userQueryService.getUserById(id));
    }
}
