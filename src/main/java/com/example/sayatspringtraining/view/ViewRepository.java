package com.example.sayatspringtraining.view;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ViewRepository extends JpaRepository<View, Integer> {
    Optional<View> findByUserIdAndVideoId(int userId, int videoId);
}
