package com.interview.user.controller;


import com.interview.user.dto.response.UserResponse;
import com.interview.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")

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

    @GetMapping("/me")
    public UserResponse me(@RequestParam Long userId) {
        return userService.getById(userId);

    @PostMapping("/auth/register")
    public UserResponse register(@RequestBody @Valid UserRequest request) {
        return userService.register(request);
    }

    @GetMapping("/users/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getById(id);

    }
}
