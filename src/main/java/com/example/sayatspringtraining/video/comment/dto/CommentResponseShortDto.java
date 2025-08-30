package com.example.sayatspringtraining.video.comment.dto;

import com.example.sayatspringtraining.channel.dto.ChannelForCommentDto;
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
