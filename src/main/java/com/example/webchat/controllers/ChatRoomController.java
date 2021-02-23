package com.example.webchat.controllers;

import com.example.webchat.models.ChatRoomModel;
import com.example.webchat.repositories.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomController {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    /**
     * Creates chat room
     * @param chatRoom
     * @return
     */
    @PostMapping("/create-chat")
    public ChatRoomModel createChatRoom(@RequestBody ChatRoomModel chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    /**
     * returns all chat rooms
     * @return
     */
    @GetMapping("/chat-rooms")
    public Iterable<ChatRoomModel> getAllChatRooms() {
        return chatRoomRepository.findAll();
    }
}