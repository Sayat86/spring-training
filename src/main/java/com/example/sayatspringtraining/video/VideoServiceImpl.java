package com.example.sayatspringtraining.video;

import com.example.sayatspringtraining.channel.Channel;
import com.example.sayatspringtraining.channel.ChannelRepository;
import com.example.sayatspringtraining.exception.ForbiddenException;
import com.example.sayatspringtraining.exception.NotFoundException;
import com.example.sayatspringtraining.user.User;
import com.example.sayatspringtraining.user.UserRepository;
import com.example.sayatspringtraining.view.View;
import com.example.sayatspringtraining.view.ViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;
    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;
    private final ViewRepository viewRepository;

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

    @Override
    public Video registerView(int videoId, Integer userId) {
        Video video = videoRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Видео не найдено"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        if (userId != null) {
            Optional<View> optionalView = viewRepository.findByUserIdAndVideoId(videoId, userId);
            if(optionalView.isPresent()) {
                View view = optionalView.get();
                // обновляем updatedAt
                // save

            } else {
                // Создаем объекь View
            }
        }

        return video;
    }
}
