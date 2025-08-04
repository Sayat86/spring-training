package com.example.sayatspringtraining.video.dto;

import lombok.Data;

@Data
public class VideoForViewDto {
    private int id;
    private String name;
    private String description;
    private int view;
    private String channel;
}
