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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    public Video create(Video video, int userId) {
        Channel channel = channelRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("Канал не найден"));
        video.setChannel(channel);
        video.setCreatedAt(LocalDateTime.now());
        video.setViews(0);
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
    @Transactional
    public Video registerView(int videoId, Integer userId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new NotFoundException("Видео не найдено"));

        if (userId != null) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new NotFoundException("Пользователь не найден"));

            Optional<View> optionalView = viewRepository.findByUserIdAndVideoId(userId, videoId);
            if (optionalView.isPresent()) {
                // Уже смотрел — просто обновим дату
                View view = optionalView.get();
                view.setUpdatedAt(LocalDateTime.now());
                viewRepository.save(view);
            } else {
                // Первый просмотр — создаём запись и увеличиваем счётчик
                View newView = new View();
                newView.setUser(user);
                newView.setVideo(video);
                newView.setCreatedAt(LocalDateTime.now());
                newView.setUpdatedAt(LocalDateTime.now());
                viewRepository.save(newView);

                video.setViews(video.getViews() + 1);
                videoRepository.save(video);
            }
        } else {
            // Анонимный пользователь — просто увеличиваем счётчик
            video.setViews(video.getViews() + 1);
            videoRepository.save(video);
        }
        return video;
    }
}
