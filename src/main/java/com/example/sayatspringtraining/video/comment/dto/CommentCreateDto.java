package com.example.sayatspringtraining.video.comment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentCreateDto {
    @NotBlank(message = "Комментарий не может быть пустым")
    @Size(max = 1000)
    private String text;
    private Integer parentId;
}
