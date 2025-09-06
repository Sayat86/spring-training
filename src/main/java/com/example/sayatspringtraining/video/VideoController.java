package com.example.sayatspringtraining.video;

import com.example.sayatspringtraining.video.comment.Comment;
import com.example.sayatspringtraining.video.comment.CommentService;
import com.example.sayatspringtraining.video.comment.dto.CommentCreateDto;
import com.example.sayatspringtraining.video.comment.dto.CommentMapper;
import com.example.sayatspringtraining.video.comment.dto.CommentResponseFullDto;
import com.example.sayatspringtraining.video.comment.dto.CommentResponseShortDto;
import com.example.sayatspringtraining.video.dto.VideoCreateDto;
import com.example.sayatspringtraining.video.dto.VideoMapper;
import com.example.sayatspringtraining.video.dto.VideoResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.sayatspringtraining.utils.RequestConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/videos")
public class VideoController {
    private final VideoService videoService;
    private final VideoMapper videoMapper;
    private final CommentMapper commentMapper;
    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VideoResponseDto create(@Valid @RequestBody VideoCreateDto videoCreate,
                                   @RequestHeader(USER_HEADER) int userId) {
        Video video = videoMapper.fromCreate(videoCreate);
        return videoMapper.toResponse(videoService.create(video, userId));
    }

    @GetMapping("/{videoId}")
    public VideoResponseDto findById(@PathVariable int videoId) {
        return videoMapper.toResponse(videoService.findById(videoId));
    }

    @GetMapping
    public List<VideoResponseDto> findAllByChannelId(@RequestParam int channelId,
                                                     @RequestParam(defaultValue = DEFAULT_FROM) int from,
                                                     @RequestParam(defaultValue = DEFAULT_SIZE) int size) {
        int page = from / size;
        return videoMapper.toResponse(videoService.findAllByChannelId(channelId, page, size));
    }

    @PostMapping("/{videoId}/views")
    public VideoResponseDto registerView(@PathVariable int videoId,
                                         @RequestHeader(value = USER_HEADER, required = false) Integer userId) {
        return videoMapper.toResponse(videoService.registerView(videoId, userId));
    }

    @PostMapping("/{videoId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponseShortDto create(@RequestBody CommentCreateDto commentCreate,
                                          @RequestHeader(USER_HEADER) int userId,
                                          @PathVariable int videoId) {
        Comment comment = commentMapper.fromCreate(commentCreate);
        return commentMapper.toResponseShort(commentService.create(comment, userId, videoId));
    }

    @GetMapping("/{videoId}/comments")
    public List<CommentResponseFullDto> findCommentsForOneVideo(@PathVariable int videoId) {
        return commentService.findCommentsForOneVideo(videoId).stream()
                .map(commentMapper::toResponseFull)
                .toList();//todo
    }

    @DeleteMapping("/{videoId}/comments/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommentById(@PathVariable int videoId,
                           @PathVariable int commentId) {
        commentService.deleteById(videoId, commentId);
    }
}
