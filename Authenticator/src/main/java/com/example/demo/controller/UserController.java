package com.example.demo.controller;

import com.example.demo.dto.Login;
import com.example.demo.dto.UserResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth-service")
public class UserController {
    private Environment environment;
    private UserService userService;


    @Autowired
    public UserController(Environment environment, UserService userService) {
        this.environment = environment;
        this.userService = userService;
    }

    @GetMapping("/status")
    public String getStatus(){
        return "Authenticator Up and Running at port no. : "+environment.getProperty("local.server.port");
    }

    @PostMapping("/register")
    public ResponseEntity<?> userSignup(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signup(user));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> userSignin(@RequestBody Login login){
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(login.getUserName(),login.getPassword()));
    }
}
