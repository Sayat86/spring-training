package com.example.sayatspringtraining.video;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {
    Page<Video> findByChannelIdAndIsHidden(int channelId, Boolean isHidden, Pageable pageable);
}
