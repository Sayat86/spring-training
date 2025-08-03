package com.example.sayatspringtraining.video;

import java.util.List;

public interface VideoService {
    Video create(Video video, int userId);
    Video findById(int videoId);
    List<Video> findAllByChannelId(int channelId, int page, int size);
    Video registerView(int videoId, Integer userId);
    List<Video> findViewsByUserId(int userId, int page, int size);
}
