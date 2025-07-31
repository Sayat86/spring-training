package com.example.sayatspringtraining.view;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ViewRepository extends JpaRepository<View, Integer> {
    Optional<View> findByUserIdAndVideoId(int userId, int videoId);
    List<View> findByUserId(int userId);
    List<View> findByVideoId(int videoId);
}
