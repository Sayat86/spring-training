package com.example.sayatspringtraining.view;

import com.example.sayatspringtraining.video.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewServiceImpl implements ViewService {
    private final ViewRepository viewRepository;

    @Override
    public List<View> findByUserId(int userId, int page, int size) {
        return viewRepository.findByUserId(userId, PageRequest.of(page, size))
                .getContent();
    }
}
