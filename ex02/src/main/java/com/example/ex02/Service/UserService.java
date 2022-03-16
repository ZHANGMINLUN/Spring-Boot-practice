package com.example.ex02.Service;

import com.example.ex02.Entity.User;
import com.example.ex02.Entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void AddUserInformation(User user){
        userRepository.save(user);
    }
}
