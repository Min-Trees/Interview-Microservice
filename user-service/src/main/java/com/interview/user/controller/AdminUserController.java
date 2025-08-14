package com.interview.user.controller;

import com.interview.user.dto.request.RoleUpdateRequest;
import com.interview.user.dto.request.StatusUpdateRequest;
import com.interview.user.dto.response.UserResponse;
import com.interview.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
public class AdminUserController {

    private final UserService userService;

    @PatchMapping("/{id}/role")
    public UserResponse updateRole(@PathVariable Long id,
                                   @RequestBody @Valid RoleUpdateRequest request) {
        return userService.updateRole(id, request.getRoleId());
    }

    @PatchMapping("/{id}/status")
    public UserResponse updateStatus(@PathVariable Long id,
                                     @RequestBody @Valid StatusUpdateRequest request) {
        return userService.updateStatus(id, request.getStatus());
    }
}
