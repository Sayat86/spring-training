package com.example.sayatspringtraining.video;

import com.example.sayatspringtraining.channel.Channel;
import com.example.sayatspringtraining.channel.ChannelRepository;
import com.example.sayatspringtraining.exception.ForbiddenException;
import com.example.sayatspringtraining.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;
    private final ChannelRepository channelRepository;

    @Override
    public Video create(Video video, int channelId) {
        Channel channel = channelRepository.findById(channelId)
                .orElseThrow(() -> new NotFoundException("Канал не найден"));
        video.setChannel(channel);
        return videoRepository.save(video);
    }

    @Override
    public Video findById(int videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new NotFoundException("Видео не найдено"));
        return video;
    }

    @Override
    public List<Video> findAllByChannelId(int channelId, int page, int size) {
        return videoRepository.findByChannelId(channelId, PageRequest.of(page, size))
                .getContent();
    }
}
