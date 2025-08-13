package com.example.sayatspringtraining.channel.dto;

import com.example.sayatspringtraining.channel.Country;
import lombok.Data;

@Data
public class ChannelForSubscriptionDto {
    private int id;
    private String name;
    private String description;
    private Country country;
}
