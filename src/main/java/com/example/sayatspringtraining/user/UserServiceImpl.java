package com.example.sayatspringtraining.user;

import com.example.sayatspringtraining.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Пользователь с таким ID не найден"));
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
