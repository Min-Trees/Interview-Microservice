package com.interview.career.service;

import com.interview.career.dto.request.CareerPreferenceRequest;
import com.interview.career.dto.response.CareerPreferenceResponse;
import com.interview.career.entity.CareerPreference;
import com.interview.career.mapper.CareerPreferenceMapper;
import com.interview.career.repository.CareerPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CareerService {

    private final CareerPreferenceRepository repository;
    private final CareerPreferenceMapper mapper;

    public CareerPreferenceResponse create(CareerPreferenceRequest request) {
        CareerPreference preference = mapper.toEntity(request);
        preference.setCreatedAt(LocalDateTime.now());
        return mapper.toResponse(repository.save(preference));
    }

    public CareerPreferenceResponse getById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElse(null);
    }

    public List<CareerPreferenceResponse> getRecommendations(Long userId) {
        return repository.findByUserId(userId).stream()
                .map(mapper::toResponse)
                .toList();
    }
}
