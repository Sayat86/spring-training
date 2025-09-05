package com.example.sayatspringtraining.channel.dto;

import com.example.sayatspringtraining.channel.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Введите страну")
    private Country country;
}
