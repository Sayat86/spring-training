package com.example.sayatspringtraining.channel;

import com.example.sayatspringtraining.channel.dto.ChannelCreateDto;
import com.example.sayatspringtraining.channel.dto.ChannelMapper;
import com.example.sayatspringtraining.channel.dto.ChannelResponseDto;
import com.example.sayatspringtraining.channel.dto.ChannelUpdateDto;
import com.example.sayatspringtraining.subscription.SubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.sayatspringtraining.utils.RequestConstants.USER_HEADER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/channels")
public class ChannelController {
    private final ChannelService channelService;
    private final ChannelMapper channelMapper;
    private final SubscriptionService subscriptionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ChannelResponseDto create(@Valid @RequestBody ChannelCreateDto channelCreate,
                                     @RequestHeader(USER_HEADER) int userId) {
        Channel channel = channelMapper.fromCreate(channelCreate);
        return channelMapper.toResponse(channelService.create(channel, userId));
    }

    @PatchMapping("/me")
    public ChannelResponseDto update(@RequestBody ChannelUpdateDto channelUpdate,
                                     @RequestHeader(USER_HEADER) int userId) {
        Channel channel = channelMapper.fromUpdate(channelUpdate);
        return channelMapper.toResponse(channelService.update(channel, userId));
    }

    @GetMapping("/{channelId}")
    public ChannelResponseDto findById(@PathVariable int channelId,
                                       @RequestHeader(USER_HEADER) int userId) {
        return channelMapper.toResponse(channelService.findById(channelId, userId));
    }

    @GetMapping("/me")
    public ChannelResponseDto getMyChannel(@RequestHeader(USER_HEADER) int userId){
        return channelMapper.toResponse(channelService.me(userId));
    }

    @PutMapping("/{channelId}/subscriptions")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void subscribeToChannel(@RequestHeader(value = USER_HEADER) int userId,
                                   @PathVariable int channelId) {
        subscriptionService.subscribeToChannel(userId, channelId);
    }

    @DeleteMapping("/{channelId}/subscriptions")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unsubscribeFromChannel(@RequestHeader(value = USER_HEADER) int userId,
                                       @PathVariable int channelId) {
        subscriptionService.unsubscribeFromChannel(userId, channelId);
    }
}
