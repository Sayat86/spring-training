package com.example.sayatspringtraining.video.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VideoDto {
    private Integer id;
    private String name;
    private String description;
}
