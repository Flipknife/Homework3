package com.example.Homework3.HW3;


import java.util.List;

public interface UserService {
        User findById(long id);
        User save(User user);

        List<User> findAll();
    }
