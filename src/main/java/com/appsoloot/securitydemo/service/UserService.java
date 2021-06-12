package com.appsoloot.securitydemo.service;

import com.appsoloot.securitydemo.model.User;
import com.appsoloot.securitydemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByName(String username) {
        return userRepository.findByName(username).orElseThrow(() -> new EntityNotFoundException("User not found."));
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
