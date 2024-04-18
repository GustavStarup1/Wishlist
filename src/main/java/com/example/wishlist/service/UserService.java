package com.example.wishlist.service;

import com.example.wishlist.model.User;
import com.example.wishlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User login(String username, String password) {
       return userRepository.login(username, password);
    }

    public void create(String username, String password, String email) {
        userRepository.createLogin(username, password, email);
    }
}
