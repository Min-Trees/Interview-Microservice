package com.interview.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.interview.user.dto.request.UserRequest;
import com.interview.user.dto.response.UserResponse;
import com.interview.user.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "role.id", source = "roleId")
    User toEntity(UserRequest request);

    @Mapping(target = "roleId", source = "role.id")
    UserResponse toResponse(User user);
}
