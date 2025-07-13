package com.example.sayatspringtraining.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private int id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
}
