package com.example.sayatspringtraining.view;

import java.util.List;

public interface ViewService {
    List<View> findByUserId(int userId);
    List<View> findByVideoId(int videoId);
}
