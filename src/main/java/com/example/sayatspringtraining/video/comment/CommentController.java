package com.example.sayatspringtraining.video.comment;

import com.example.sayatspringtraining.like.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.sayatspringtraining.utils.RequestConstants.USER_HEADER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final LikeService likeService;

    @PutMapping("/{commentId}/likes")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void likeComment(@RequestHeader(value = USER_HEADER) Integer userId,
                            @PathVariable Integer commentId) {
        likeService.likeComment(userId, commentId);
    }

    @DeleteMapping("/{commentId}/likes")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unlikeComment(@RequestHeader(value = USER_HEADER) Integer userId,
                              @PathVariable Integer commentId) {
        likeService.unlikeComment(userId, commentId);
    }
}
