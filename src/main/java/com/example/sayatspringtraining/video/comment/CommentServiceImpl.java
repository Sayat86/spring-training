package com.example.sayatspringtraining.video.comment;

import com.example.sayatspringtraining.channel.Channel;
import com.example.sayatspringtraining.channel.ChannelRepository;
import com.example.sayatspringtraining.exception.NotFoundException;
import com.example.sayatspringtraining.user.User;
import com.example.sayatspringtraining.user.UserRepository;
import com.example.sayatspringtraining.video.Video;
import com.example.sayatspringtraining.video.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ChannelRepository channelRepository;
    private final VideoRepository videoRepository;

    @Override
    public Comment create(Comment comment, int userId, int videoId) {

        Channel channel = channelRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("Канал для пользователя с id=%d не найден".formatted(userId)));
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new NotFoundException("Видео не найдено"));
        comment.setChannel(channel);
        comment.setVideo(video);
        comment.setCreatedAt(LocalDateTime.now());
        comment.setLikes(0);

        if (comment.getParentComment() != null) {
            Comment parent = commentRepository.findById(comment.getParentComment().getId())
                    .orElseThrow(() -> new NotFoundException("Комментарий не найден"));
            if (parent.getParentComment() != null) {
                comment.setParentComment(parent.getParentComment());
            } else {
                comment.setParentComment(parent);
            }
        }
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findCommentsForOneVideo(int videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new NotFoundException("Видео не найдено"));

        return commentRepository.findByVideoIdAndParentCommentIsNullOrderByCreatedAt(videoId);
    }
}
