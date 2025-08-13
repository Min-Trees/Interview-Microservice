package com.interview.user.service;

import com.interview.user.dto.request.UserRequest;
import com.interview.user.dto.response.UserResponse;
import com.interview.user.entity.*;
import com.interview.user.mapper.UserMapper;
import com.interview.user.repository.RoleRepository;
import com.interview.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public UserResponse register(UserRequest request) {
        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));
        User user = userMapper.toEntity(request);
        user.setRole(role);
        user.setStatus(UserStatus.PENDING);
        user.setEloScore(0);
        user.setEloRank(EloRank.NEWBIE);
        user.setCreatedAt(LocalDateTime.now());
        return userMapper.toResponse(userRepository.save(user));
    }

    public UserResponse getById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElse(null);
    }
}
