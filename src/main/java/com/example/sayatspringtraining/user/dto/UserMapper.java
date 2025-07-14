package com.example.sayatspringtraining.user.dto;

import com.example.sayatspringtraining.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User fromCreate(UserCreateDto userCreate) {
        User user = new User();
        user.setEmail(userCreate.getEmail());
        user.setName(userCreate.getName());
        return user;
    }

    public UserResponseDto toResponse(User user) {
        UserResponseDto userResponse = new UserResponseDto();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setCreatedAt(user.getCreatedAt());
        return userResponse;
    }
}
