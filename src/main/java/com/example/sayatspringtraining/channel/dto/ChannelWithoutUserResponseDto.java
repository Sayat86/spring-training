package com.example.sayatspringtraining.channel.dto;

import com.example.sayatspringtraining.channel.Country;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChannelWithoutUserResponseDto {
    private int id;
    private String name;
    private String description;
    private Country country;
    private LocalDateTime createdAt;
}
