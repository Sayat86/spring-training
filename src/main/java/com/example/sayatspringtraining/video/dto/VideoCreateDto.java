package com.example.sayatspringtraining.video.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VideoCreateDto {
    @NotBlank(message = "Название видео не может быть пустым")
    @Size(min = 3, max = 200)
    private String name;
    @NotBlank(message = "Описание видео не может быть пустым")
    @Size(max = 1000)
    private String description;
    private Boolean isHidden;
}
