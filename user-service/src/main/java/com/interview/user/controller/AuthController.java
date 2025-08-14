package com.interview.user.controller;

import com.interview.user.dto.request.LoginRequest;
import com.interview.user.dto.request.UserRequest;
import com.interview.user.dto.request.VerifyRequest;
import com.interview.user.dto.response.UserResponse;
import com.interview.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody @Valid UserRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody @Valid LoginRequest request) {
        return userService.login(request);
    }

    @PostMapping("/verify")
    public UserResponse verify(@RequestBody @Valid VerifyRequest request) {
        return userService.verify(request.getUserId());
    }
}
