package com.example.sayatspringtraining.channel.dto;

import com.example.sayatspringtraining.channel.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChannelUpdateDto {
    @Size(max = 50)
    private String name;
    @Size(max = 1000)
    private String description;
    @NotBlank(message = "Введите страну")
    private Country country;
}
