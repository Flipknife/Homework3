package com.example.Homework3.HW3;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Long, User> users = new HashMap<>();

    @Override
    public User findById(long id) {
        return users.get(id);
    }

    @Override
    public User save(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}