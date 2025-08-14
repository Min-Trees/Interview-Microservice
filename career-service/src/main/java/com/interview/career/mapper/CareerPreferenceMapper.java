package com.interview.career.mapper;

import com.interview.career.dto.request.CareerPreferenceRequest;
import com.interview.career.dto.response.CareerPreferenceResponse;
import com.interview.career.entity.CareerPreference;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CareerPreferenceMapper {
    CareerPreference toEntity(CareerPreferenceRequest request);

    CareerPreferenceResponse toResponse(CareerPreference preference);
}
