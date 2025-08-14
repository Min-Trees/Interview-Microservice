package com.interview.user.controller;

import com.interview.user.dto.request.EloApplyRequest;
import com.interview.user.dto.response.UserResponse;
import com.interview.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/internal/elo")
@RequiredArgsConstructor
public class EloController {

    private final UserService userService;

    @PostMapping("/apply")
    public UserResponse apply(@RequestBody @Valid EloApplyRequest request) {
        return userService.applyElo(request);
    }
}
