package com.example.sayatspringtraining.video;

import java.util.List;

public interface VideoService {
    Video create(Video video, int channelId);
    Video findById(int videoId);
    List<Video> findAllByChannelId(int channelId, int page, int size);
}
