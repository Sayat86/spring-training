package com.example.sayatspringtraining.subscription;

import com.example.sayatspringtraining.channel.dto.ChannelForSubscriptionDto;
import com.example.sayatspringtraining.channel.dto.ChannelMapper;
import com.example.sayatspringtraining.video.dto.VideoMapper;
import com.example.sayatspringtraining.video.dto.VideoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.sayatspringtraining.utils.RequestConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class SubscriptionController {
    private final ChannelMapper channelMapper;
    private final SubscriptionService subscriptionService;
    private final VideoMapper videoMapper;

    @GetMapping
    public List<ChannelForSubscriptionDto> getChannelsForSubscription(@RequestHeader(value = USER_HEADER) int userId) {
        return channelMapper.toResponseSubscription(subscriptionService.findSubscribedChannelsByUserId(userId));
    }

    @GetMapping("/videos")
    public List<VideoResponseDto> getVideoSubscribedChannels(@RequestHeader(value = USER_HEADER) int userId,
                                                             @RequestParam(required = false) List<Integer> videos,
                                                             @RequestParam(defaultValue = DEFAULT_FROM) int from,
                                                             @RequestParam(defaultValue = DEFAULT_SIZE) int size) {
        int page = from / size;
        return videoMapper.toResponse(subscriptionService.findVideoSubscribedChannels(userId, videos, page, size));
    }
}
