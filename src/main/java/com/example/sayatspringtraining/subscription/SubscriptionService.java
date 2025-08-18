package com.example.sayatspringtraining.subscription;

import com.example.sayatspringtraining.channel.Channel;
import com.example.sayatspringtraining.video.Video;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SubscriptionService {
    List<Channel> findSubscribedChannelsByUserId(int userId);

    void subscribeToChannel(int userId, int channelId);
    void unsubscribeFromChannel(int userId, int channelId);
    List<Video> findVideoSubscribedChannels(int userId, int page, int size);
}
