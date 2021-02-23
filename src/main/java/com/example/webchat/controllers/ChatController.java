package com.example.webchat.controllers;

import com.example.webchat.models.ChatModel;
import com.example.webchat.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @Autowired
    private ChatRepository chatRepository;

    /**
     * Subscribes user for new chat and creates field in DB with userId and chatRoomId to get all user's chats in future
     * @param chat {userId, chatId}
     */
    @PostMapping("/subscribe")
    public void subscribeChat(@RequestBody ChatModel chat) {
        chatRepository.save(chat);
    }
}
