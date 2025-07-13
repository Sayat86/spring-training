package com.example.sayatspringtraining.user;

import com.example.sayatspringtraining.user.dto.UserCreateDto;
import com.example.sayatspringtraining.user.dto.UserMapper;
import com.example.sayatspringtraining.user.dto.UserResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@Valid @RequestBody UserCreateDto userCreate) {
        User user = userMapper.fromCreate(userCreate);
        return userMapper.toResponse(userService.create(user));
    }

    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable int id) {
        return userMapper.toResponse(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }
}
