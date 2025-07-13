package com.example.sayatspringtraining.channel.dto;

import com.example.sayatspringtraining.user.User;
import lombok.Data;

@Data
public class ChannelResponseDto {
    private int id;
    private String name;
    private String description;
    private String country;
    private User user; //todo
}
