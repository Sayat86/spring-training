package com.example.sayatspringtraining.view;

import com.example.sayatspringtraining.video.Video;

import java.util.List;

public interface ViewService {
    List<View> findByUserId(int userId, int page, int size);
}
