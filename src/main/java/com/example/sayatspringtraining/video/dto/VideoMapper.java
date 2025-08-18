package com.example.sayatspringtraining.video.dto;

import com.example.sayatspringtraining.channel.dto.ChannelWithoutUserResponseDto;
import com.example.sayatspringtraining.video.Video;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VideoMapper {
    public Video fromCreate(VideoCreateDto videoCreate) {
        Video video = new Video();
        video.setName(videoCreate.getName());
        video.setDescription(videoCreate.getDescription());
        video.setIsHidden(videoCreate.getIsHidden());
        return video;
    }

    public VideoResponseDto toResponse(Video video) {
        VideoResponseDto videoResponse = new VideoResponseDto();
        ChannelWithoutUserResponseDto channelResponse = new ChannelWithoutUserResponseDto();

        channelResponse.setId(video.getChannel().getId());
        channelResponse.setName(video.getChannel().getName());
        channelResponse.setDescription(video.getChannel().getDescription());
        channelResponse.setCountry(video.getChannel().getCountry());
        channelResponse.setCreatedAt(video.getChannel().getCreatedAt());

        videoResponse.setId(video.getId());
        videoResponse.setName(video.getName());
        videoResponse.setDescription(video.getDescription());
        videoResponse.setIsHidden(video.getIsHidden());
        videoResponse.setCreatedAt(video.getCreatedAt());
        videoResponse.setViews(video.getViews());
        videoResponse.setChannel(channelResponse);
        return videoResponse;
    }

    public List<VideoResponseDto> toResponse(List<Video> videos) {
        return videos.stream()
                .map(this::toResponse)
                .toList();
    }
}
