package com.example.sayatspringtraining.video;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VideoResponseDto create(@Valid @RequestBody VideoCreateDto videoCreate,
                                   @RequestHeader(USER_HEADER) int channelId) { //todo
        Video video = videoMapper.fromCreate(videoCreate);
        return videoMapper.toResponse(videoService.create(video, channelId));
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
}
