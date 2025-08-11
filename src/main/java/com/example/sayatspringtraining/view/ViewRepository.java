package com.example.sayatspringtraining.view;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ViewRepository extends JpaRepository<View, Integer> {
    Optional<View> findByUserIdAndVideoId(int userId, int videoId);

    @EntityGraph(attributePaths = {"video", "video.channel"})
    Page<View> findByUserId(int userId, Pageable pageable);
}
