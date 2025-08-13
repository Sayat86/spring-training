package com.example.sayatspringtraining.subscription;

import com.example.sayatspringtraining.channel.Channel;

import java.util.List;

public interface SubscriptionService {
    List<Channel> findSubscribedChannelsByUserId(int userId);
}
