package com.example.sayatspringtraining.view.dto;

import com.example.sayatspringtraining.channel.dto.ChannelWithoutUserResponseDto;
import com.example.sayatspringtraining.video.dto.VideoForViewDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ViewResponseDto {
    private int id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private VideoForViewDto video;
}
