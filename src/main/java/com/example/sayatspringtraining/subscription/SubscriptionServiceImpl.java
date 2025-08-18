package com.example.sayatspringtraining.subscription;

import com.example.sayatspringtraining.channel.Channel;
import com.example.sayatspringtraining.channel.ChannelRepository;
import com.example.sayatspringtraining.exception.NotFoundException;
import com.example.sayatspringtraining.user.User;
import com.example.sayatspringtraining.user.UserRepository;
import com.example.sayatspringtraining.video.Video;
import com.example.sayatspringtraining.video.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService{
    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;
    private final VideoRepository videoRepository;

    @Override
    public List<Channel> findSubscribedChannelsByUserId(int userId) {
        List<Channel> channels = channelRepository.findAllBySubscribersId(userId);
        if (channels.isEmpty()) {
            throw new NotFoundException("Подписки пользователя не найдены");
        }
        return channels;
    }

    @Transactional
    @Override
    public void subscribeToChannel(int userId, int channelId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        Channel channel = channelRepository.findById(channelId)
                .orElseThrow(() -> new NotFoundException("Канал не найден"));

        if (!user.getSubscribedChannels().contains(channel)) {
            user.getSubscribedChannels().add(channel);
            userRepository.save(user);
        }
    }

    @Transactional
    @Override
    public void unsubscribeFromChannel(int userId, int channelId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        Channel channel = channelRepository.findById(channelId)
                .orElseThrow(() -> new NotFoundException("Канал не найден"));

        if (user.getSubscribedChannels().remove(channel)) {
            userRepository.save(user);
        }
    }

    @Override
    public List<Video> findVideoSubscribedChannels(int userId, List<Integer> videos, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return videoRepository.findAllByChannelSubscribersIdAndIsHiddenFalseOrderByCreatedAtDesc(userId, videos, pageable).getContent();
    }
}
