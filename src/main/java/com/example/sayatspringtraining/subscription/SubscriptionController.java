package com.example.sayatspringtraining.subscription;

import com.example.sayatspringtraining.channel.dto.ChannelForSubscriptionDto;
import com.example.sayatspringtraining.channel.dto.ChannelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.sayatspringtraining.utils.RequestConstants.USER_HEADER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class SubscriptionController {
    private final ChannelMapper channelMapper;
    private final SubscriptionService subscriptionService;

    @GetMapping
    public List<ChannelForSubscriptionDto> getChannelsForSubscription(@RequestHeader(value = USER_HEADER) int userId) {
        return channelMapper.toResponseSubscription(subscriptionService.findSubscribedChannelsByUserId(userId));
    }
}
