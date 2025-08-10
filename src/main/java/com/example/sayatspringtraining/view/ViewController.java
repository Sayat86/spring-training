package com.example.sayatspringtraining.view;

import com.example.sayatspringtraining.view.dto.ViewMapper;
import com.example.sayatspringtraining.view.dto.ViewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.sayatspringtraining.utils.RequestConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/views")
public class ViewController {
    private final ViewService viewService;
    private final ViewMapper viewMapper;

    @GetMapping
    public List<ViewResponseDto> findAllViewsByUser(@RequestHeader(value = USER_HEADER) int userId,
                                                    @RequestParam(defaultValue = DEFAULT_FROM) int from,
                                                    @RequestParam(defaultValue = DEFAULT_SIZE) int size) {
        int page = from / size;
        return viewMapper.toResponse(viewService.findByUserId(userId, page, size));
    }
}
