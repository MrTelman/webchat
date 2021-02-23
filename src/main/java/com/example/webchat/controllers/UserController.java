package com.example.webchat.controllers;


import com.example.webchat.models.ChatRoomModel;
import com.example.webchat.models.UserModel;
import com.example.webchat.repositories.ChatRoomRepository;

import com.example.webchat.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @GetMapping("/my-chats")
    public Iterable<ChatRoomModel> getMyChats(UserServiceImpl userService) {
        return chatRoomRepository.findMyChats(userService.getCurrentUser().getId());
    }

    @PostMapping("/create-user")
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @GetMapping("/active-users")
    public Iterable<UserModel> getActiveUsers() {
        return userService.findActive();
    }

    @GetMapping("/users")
    public Iterable<UserModel> getAllUsers() {return userService.getAllUsers();}
}
