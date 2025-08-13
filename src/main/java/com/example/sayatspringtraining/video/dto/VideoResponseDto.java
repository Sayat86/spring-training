package com.example.sayatspringtraining.video.dto;

import com.example.sayatspringtraining.channel.dto.ChannelWithoutUserResponseDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VideoResponseDto {
    private int id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private Boolean isHidden;
    private Integer views;
    private ChannelWithoutUserResponseDto channel;
}
