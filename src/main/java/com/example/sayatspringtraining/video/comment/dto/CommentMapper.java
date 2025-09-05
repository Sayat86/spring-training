package com.example.sayatspringtraining.video.comment.dto;

import com.example.sayatspringtraining.channel.Channel;
import com.example.sayatspringtraining.video.Video;
import com.example.sayatspringtraining.video.comment.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentMapper {
    public CommentResponseShortDto toResponseShort(Comment comment) {
        CommentResponseShortDto commentResponseShort = new CommentResponseShortDto();
        commentResponseShort.setId(comment.getId());
        commentResponseShort.setText(comment.getText());
        commentResponseShort.setCreatedAt(comment.getCreatedAt());

        ChannelForCommentDto channel = new ChannelForCommentDto();
        channel.setId(comment.getChannel().getId());
        channel.setName(comment.getChannel().getName());
        commentResponseShort.setChannel(channel);

        commentResponseShort.setLikes(comment.getLikes());
        return commentResponseShort;
    }

    public CommentResponseFullDto toResponseFull(Comment comment) {
        CommentResponseFullDto commentResponseFull = new CommentResponseFullDto();
        ChannelForCommentDto channel = new ChannelForCommentDto();

        commentResponseFull.setId(comment.getId());
        commentResponseFull.setText(comment.getText());
        commentResponseFull.setCreatedAt(comment.getCreatedAt());

        channel.setId(comment.getChannel().getId());
        channel.setName(comment.getChannel().getName());
        commentResponseFull.setChannel(channel);

        commentResponseFull.setLikes(comment.getLikes());

        List<CommentResponseShortDto> answers = comment.getAnswers().stream()
                .map(this::toResponseShort)
                .collect(Collectors.toList());
        commentResponseFull.setAnswers(answers);

        return commentResponseFull;
    }

    public Comment fromCreate(CommentCreateDto commentCreate) {
        Comment comment = new Comment();
        comment.setText(commentCreate.getText());

        if (commentCreate.getParentId() != null) {
            Comment parentComment = new Comment();
            parentComment.setId(commentCreate.getParentId());
            comment.setParentComment(parentComment);// todo
        }
        return comment;
    }
}
