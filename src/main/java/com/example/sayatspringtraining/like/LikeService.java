package com.example.sayatspringtraining.like;

public interface LikeService {
    void likeVideo(int userId, int videoId);
    void unlikeVideo(int userId, int videoId);
}
