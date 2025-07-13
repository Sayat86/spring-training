package com.example.sayatspringtraining.channel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ChannelCreateDto {
    @NotBlank(message = "Имя канала не может быть пустым")
    @Size(min = 3, max = 50)
    private String name;
    @NotBlank(message = "Описание не может быть пустым")
    @Size(max = 1000)
    private String description;
    @NotBlank(message = "Введите страну")
    private String country;
}
