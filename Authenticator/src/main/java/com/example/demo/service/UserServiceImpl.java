package com.example.demo.service;

import com.example.demo.dto.UserResponse;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String signup(User user) {
        userRepository.save(user);
        return "profile created ";
    }

    @Override
    public UserResponse login(String userName, String password) {
        User usr = userRepository.findByUserNameAndPassword(userName,password);
        if(usr == null){
            return new UserResponse(false,"Unknow","Invalid User");
        }
        return new UserResponse(true,usr.getUserType(),"Valid user");
    }
}
