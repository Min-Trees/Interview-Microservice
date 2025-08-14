package com.interview.career.controller;

import com.interview.career.dto.request.CareerPreferenceRequest;
import com.interview.career.dto.response.CareerPreferenceResponse;
import com.interview.career.service.CareerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CareerController {

    private final CareerService careerService;

    @PostMapping("/career-preferences")
    public CareerPreferenceResponse create(@RequestBody @Valid CareerPreferenceRequest request) {
        return careerService.create(request);
    }

    @GetMapping("/career-preferences/{id}")
    public CareerPreferenceResponse get(@PathVariable Long id) {
        return careerService.getById(id);
    }
}
