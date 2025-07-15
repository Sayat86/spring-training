package com.example.sayatspringtraining.channel.dto;

import com.example.sayatspringtraining.channel.Country;
import com.example.sayatspringtraining.user.dto.UserResponseDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChannelResponseDto {
    private int id;
    private String name;
    private String description;
    private Country country;
    private LocalDateTime createdAt;
    private UserResponseDto user; //todo
}
