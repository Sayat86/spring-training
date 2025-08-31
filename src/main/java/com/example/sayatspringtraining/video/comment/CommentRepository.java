package com.example.sayatspringtraining.video.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByVideoIdOrderByCreatedAt(int videoId);
}
