package com.example.sayatspringtraining.channel.dto;

import com.example.sayatspringtraining.channel.Channel;
import com.example.sayatspringtraining.user.User;
import org.springframework.stereotype.Component;

@Component
public class ChannelMapper {
    public Channel fromCreate(ChannelCreateDto channelCreate) {
        Channel channel = new Channel();
        channel.setName(channelCreate.getName());
        channel.setDescription(channelCreate.getDescription());
        channel.setCountry(channelCreate.getCountry());
        return channel;
    }

    public ChannelResponseDto toResponse(Channel channel) {
        ChannelResponseDto channelResponse = new ChannelResponseDto();
        channelResponse.setUser(channel.getUser()); // todo
        channelResponse.setId(channel.getId());
        channelResponse.setName(channel.getName());
        channelResponse.setDescription(channel.getDescription());
        channelResponse.setCountry(channel.getCountry());
        return channelResponse;
    }
}
