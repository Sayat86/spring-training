package com.example.sayatspringtraining.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewServiceImpl implements ViewService {
    private final ViewRepository viewRepository;

    @Override
    public List<View> findByUserId(int userId) {
        return viewRepository.findByUserId(userId);
    }

    @Override
    public List<View> findByVideoId(int videoId) {
        return viewRepository.findByVideoId(videoId);
    }
}
