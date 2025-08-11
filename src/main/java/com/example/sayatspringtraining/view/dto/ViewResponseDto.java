package com.example.sayatspringtraining.view.dto;

import com.example.sayatspringtraining.video.dto.VideoForViewDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ViewResponseDto {
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private VideoForViewDto video;
}
