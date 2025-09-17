package com.example.sayatspringtraining.video;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {
    Page<Video> findByChannelIdAndIsHidden(int channelId, Boolean isHidden, Pageable pageable);

    Page<Video> findAllByChannelSubscribersIdAndIsHiddenFalseOrderByCreatedAtDesc(int userId, Pageable pageable);

    @Query(value = """
        SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END
        FROM video_likes
        WHERE user_id = :userId
          AND video_id = :videoId
        """, nativeQuery = true)
    boolean existsByUserAndVideo(@Param("userId") int userId,
                                 @Param("videoId") int videoId);

    @Modifying
    @Transactional
    @Query(value = """
        DELETE FROM video_likes
        WHERE user_id = :userId AND video_id = :videoId
        """, nativeQuery = true)
    int deleteByUserAndVideo(@Param("userId") int userId,
                             @Param("videoId") int videoId);
}
