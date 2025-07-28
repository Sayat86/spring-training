package com.example.sayatspringtraining.channel.dto;

import com.example.sayatspringtraining.channel.Channel;
import com.example.sayatspringtraining.user.dto.UserResponseDto;
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
        UserResponseDto userResponse = new UserResponseDto();

        userResponse.setId(channel.getUser().getId());
        userResponse.setName(channel.getUser().getName());
        userResponse.setEmail(channel.getUser().getEmail());
        userResponse.setCreatedAt(channel.getUser().getCreatedAt());

        channelResponse.setUser(userResponse);
        channelResponse.setId(channel.getId());
        channelResponse.setName(channel.getName());
        channelResponse.setDescription(channel.getDescription());
        channelResponse.setCountry(channel.getCountry());
        channelResponse.setCreatedAt(channel.getCreatedAt());
        return channelResponse;
    }

    public Channel fromUpdate(ChannelUpdateDto channelUpdate) {
        Channel channel = new Channel();
        channel.setName(channelUpdate.getName());
        channel.setDescription(channelUpdate.getDescription());
        channel.setCountry(channelUpdate.getCountry());
        return channel;
    }

    public void merge(Channel existingChannel, Channel updateChannel) {
        if (updateChannel.getName() != null && !updateChannel.getName().isBlank()) {
            existingChannel.setName(updateChannel.getName());
        }
        if (updateChannel.getDescription() != null && !updateChannel.getDescription().isBlank()) {
            existingChannel.setDescription(updateChannel.getDescription());
        }
        if (updateChannel.getCountry() != null) {
            existingChannel.setCountry(updateChannel.getCountry());
        }
    }
}
