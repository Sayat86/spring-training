package com.example.sayatspringtraining.subscription;

import com.example.sayatspringtraining.channel.Channel;
import com.example.sayatspringtraining.channel.ChannelRepository;
import com.example.sayatspringtraining.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService{
    private final ChannelRepository channelRepository;

    @Override
    public List<Channel> findSubscribedChannelsByUserId(int userId) {
        List<Channel> channels = channelRepository.findAllBySubscribersId(userId);
        if (channels.isEmpty()) {
            throw new NotFoundException("Подписки пользователя не найдены");
        }
        return channels;
    }
}
