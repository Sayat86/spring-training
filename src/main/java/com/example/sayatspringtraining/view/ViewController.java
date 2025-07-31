package com.example.sayatspringtraining.view;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/views")
public class ViewController {
    private final ViewService viewService;

    @GetMapping("/{userId}")
    public List<View> findByUserId(@PathVariable int userId) {
        return viewService.findByUserId(userId);
    }

    @GetMapping("/{videoId}")
    public List<View> findByVideoId(@PathVariable int videoId) {
        return viewService.findByVideoId(videoId);
    }
}
