package com.example.sayatspringtraining.video.comment;

import java.util.List;

public interface CommentService {
    Comment create(Comment comment, int channelId, int videoId);
    List<Comment> findCommentsForOneVideo(int videoId);
    void deleteById(int videoId, int commentId, int currentUserId);
}
