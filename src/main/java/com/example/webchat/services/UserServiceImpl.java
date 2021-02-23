package com.example.webchat.services;

import com.example.webchat.models.UserModel;
import com.example.webchat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserServiceImpl implements UserService{
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public UserModel createUser(UserModel user) {
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        return userRepository.save(user);
    }

    @Override
    public UserModel getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

        return userRepository.findByLogin(principal.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
    }

    public Iterable<UserModel> findActive() {
        return userRepository.findActiveUsers();
    }

    public Iterable<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
}
