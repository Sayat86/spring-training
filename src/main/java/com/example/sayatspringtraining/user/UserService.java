package com.example.sayatspringtraining.user;

import com.example.sayatspringtraining.channel.Channel;

import java.util.List;

public interface UserService {
    User create(User user);
    User findById(int id);
    void deleteById(int id);
    List<Channel> getSubscribedChannels(int userId);
}
