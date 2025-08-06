package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserMapper userMapper;
    private final StringRedisTemplate redisTemplate;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        userMapper.insert(user);
        redisTemplate.opsForValue().set("user:" + user.getId(), user.getUsername());
        return user;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }
}