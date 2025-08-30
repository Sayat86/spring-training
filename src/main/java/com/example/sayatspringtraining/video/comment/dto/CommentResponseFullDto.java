package com.example.sayatspringtraining.video.comment.dto;

import com.example.sayatspringtraining.channel.dto.ChannelForCommentDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CommentResponseFullDto {
    private int id;
    private String text;
    private LocalDateTime createdAt;
    private ChannelForCommentDto channel;
    private Integer likes;
    private List<CommentResponseShortDto> answers;
}
