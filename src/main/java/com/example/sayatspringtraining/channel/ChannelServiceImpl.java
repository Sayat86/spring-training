package com.example.sayatspringtraining.channel;

import com.example.sayatspringtraining.exception.NotFoundException;
import com.example.sayatspringtraining.user.User;
import com.example.sayatspringtraining.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;

    @Override
    public Channel create(Channel channel, int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь с таким ID не найден"));
        channel.setUser(user);
        channel.setCreatedAt(LocalDateTime.now());
        return channelRepository.save(channel);
    }

    @Override
    public Channel findById(int channelId, int userId) {
        Channel channel = channelRepository.findById(channelId)
                .orElseThrow(() -> new NotFoundException("Канал пользователя не найден"));
        return channel;
    }

    @Override
    public Channel me(int userId) {
        return channelRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("Канал не найден"));
    }

    @Override
    public List<Channel> findAllByOwnerId(int ownerId) {
        return null;
    }
}
