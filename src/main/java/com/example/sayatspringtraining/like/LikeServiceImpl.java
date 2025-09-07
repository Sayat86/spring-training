package com.example.sayatspringtraining.like;

import com.example.sayatspringtraining.exception.ConflictException;
import com.example.sayatspringtraining.exception.NotFoundException;
import com.example.sayatspringtraining.user.User;
import com.example.sayatspringtraining.user.UserRepository;
import com.example.sayatspringtraining.video.Video;
import com.example.sayatspringtraining.video.VideoRepository;
import com.example.sayatspringtraining.video.comment.Comment;
import com.example.sayatspringtraining.video.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final UserRepository userRepository;
    private final VideoRepository videoRepository;
    private final CommentRepository commentRepository;

    @Transactional
    @Override
    public void likeVideo(int userId, int videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new NotFoundException("Видео не найдено"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        if (user.getLikedVideos().contains(video)) {
            throw new NotFoundException("Пользователь уже поставил лайк этому видео");
        }
        user.getLikedVideos().add(video);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void unlikeVideo(int userId, int videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new NotFoundException("Видео не найдено"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        if (!user.getLikedVideos().remove(video)) {
            throw new ConflictException("Пользователь не ставил лайк этому видео");
        }
            userRepository.save(user);
    }

    @Transactional
    @Override
    public void likeComment(Integer userId, Integer commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Комментарий не найден"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
        if (user.getLikedComments().contains(comment)) {
            throw new NotFoundException("Пользователь уже поставил лайк этому комментарию");
        }
        user.getLikedComments().add(comment);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void unlikeComment(Integer userId, Integer commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Комментарий не найден"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));

        if (!user.getLikedComments().remove(comment)) {
            throw new ConflictException("Пользователь не ставил лайк этому комментарию");
        }
        user.getLikedComments().add(comment);
        userRepository.save(user);
    }
}
