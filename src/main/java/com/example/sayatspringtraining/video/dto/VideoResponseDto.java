package com.example.sayatspringtraining.video.dto;

import com.example.sayatspringtraining.channel.dto.ChannelResponseDto;
import lombok.Data;

@Data
public class VideoResponseDto {
    private int id;
    private String name;
    private String description;
    private Boolean isHidden;
    private Integer views;
    private ChannelResponseDto channel;
}
