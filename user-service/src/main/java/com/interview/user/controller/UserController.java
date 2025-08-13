package com.interview.user.controller;

import com.interview.user.dto.request.UserRequest;
import com.interview.user.dto.response.UserResponse;
import com.interview.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/auth/register")
    public UserResponse register(@RequestBody @Valid UserRequest request) {
        return userService.register(request);
    }

    @GetMapping("/users/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getById(id);
    }
}
