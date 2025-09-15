package com.example.sayatspringtraining.user;

import com.example.sayatspringtraining.channel.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Query(value = "delete from comment_likes where user_id = :userId and comment_id = :commentId", nativeQuery = true)
    int deleteCommentByUserIdAndCommentId(int userId, int commentId);

    @Modifying
    @Query(value = "insert into comment_likes (user_id, comment_id) values (:userId, :commentId)", nativeQuery = true)
    void addLikeToComment(int userId, int commentId);
}
