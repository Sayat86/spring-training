package com.example.sayatspringtraining.user;

public interface UserService {
    User create(User user);
    User findById(int id);
    void deleteById(int id);
}
