package com.interview.user.service;

import com.interview.user.dto.request.EloApplyRequest;
import com.interview.user.dto.request.LoginRequest;
import com.interview.user.dto.request.UserRequest;
import com.interview.user.dto.response.UserResponse;
import com.interview.user.entity.*;
import com.interview.user.mapper.UserMapper;
import com.interview.user.repository.EloHistoryRepository;
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
    private final EloHistoryRepository historyRepository;
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

    public UserResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        if (user.getStatus() != UserStatus.VERIFIED) {
            throw new IllegalStateException("User not verified");
        }
        return userMapper.toResponse(user);
    }

    public UserResponse verify(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setStatus(UserStatus.VERIFIED);
        return userMapper.toResponse(userRepository.save(user));
    }

    public UserResponse getById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElse(null);
    }

    public UserResponse updateRole(Long id, Long roleId) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));
        user.setRole(role);
        return userMapper.toResponse(userRepository.save(user));
    }

    public UserResponse updateStatus(Long id, UserStatus status) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setStatus(status);
        return userMapper.toResponse(userRepository.save(user));
    }

    public UserResponse applyElo(EloApplyRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.setEloScore(user.getEloScore() + request.getPoints());
        user.setEloRank(calculateRank(user.getEloScore()));

        EloHistory history = new EloHistory();
        history.setUser(user);
        history.setAction(request.getAction());
        history.setPoints(request.getPoints());
        history.setDescription(request.getDescription());
        history.setCreatedAt(LocalDateTime.now());
        historyRepository.save(history);

        return userMapper.toResponse(userRepository.save(user));
    }

    private EloRank calculateRank(int score) {
        if (score >= 700) return EloRank.LEGEND;
        if (score >= 600) return EloRank.MASTER;
        if (score >= 500) return EloRank.SENIOR_EXPERT;
        if (score >= 400) return EloRank.EXPERT;
        if (score >= 300) return EloRank.SOLVER;
        if (score >= 200) return EloRank.CONTRIBUTOR;
        if (score >= 100) return EloRank.LEARNER;
        return EloRank.NEWBIE;
    }
}
