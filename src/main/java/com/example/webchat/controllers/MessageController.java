package com.example.webchat.controllers;

import com.example.webchat.models.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * Frontend listens WS by subscribed chat rooms ID's and interacts with messages with room
     * @param id
     * @param message
     */
    @MessageMapping("/chats/{id}")
    public void sendMessage(@DestinationVariable String id, MessageModel message) {
        simpMessagingTemplate.convertAndSend("/topic/messages/" + id, message);
    }
}
