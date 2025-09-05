package com.example.sayatspringtraining.video.comment.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponseShortDto {
    private int id;
    private String text;
    private LocalDateTime createdAt;
    private ChannelForCommentDto channel;
    private Integer likes;
}
