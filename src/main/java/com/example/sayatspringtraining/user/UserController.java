package com.example.sayatspringtraining.user;

import com.example.sayatspringtraining.user.dto.UserCreateDto;
import com.example.sayatspringtraining.user.dto.UserMapper;
import com.example.sayatspringtraining.user.dto.UserResponseDto;
import com.example.sayatspringtraining.video.Video;
import com.example.sayatspringtraining.video.VideoService;
import com.example.sayatspringtraining.video.dto.VideoDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final VideoService videoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@Valid @RequestBody UserCreateDto userCreate) {
        User user = userMapper.fromCreate(userCreate);
        return userMapper.toResponse(userService.create(user));
    }

    @GetMapping("/{userId}")
    public UserResponseDto findById(@PathVariable int userId) {
        return userMapper.toResponse(userService.findById(userId));
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int userId) {
        userService.deleteById(userId);
    }

    @GetMapping("/{userId}/liked-videos")
    public List<VideoDto> getLikedVideosByUserId(@PathVariable Integer userId) {
        List<Video> likedVideos = videoService.getLikedVideosByUser(userId);
        return likedVideos.stream()
                .map(v -> new VideoDto(v.getId(), v.getName(), v.getDescription()))
                .toList();
    }
}
