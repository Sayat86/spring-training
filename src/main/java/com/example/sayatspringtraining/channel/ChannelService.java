package com.example.sayatspringtraining.channel;

import java.util.List;

public interface ChannelService {
    Channel create(Channel channel, int userId);
    Channel findById(int channelId, int userId);
    Channel me(int userId);
    Channel update(Channel channel, int userId);
    List<Channel> findAllByOwnerId(int ownerId);
}
