package com.example.demo.service;

import com.example.demo.dto.UserResponse;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public String signup(User user);
    public UserResponse login(String userName, String password);
}
