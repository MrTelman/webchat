package com.example.webchat.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chats")
public class ChatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;

    private long chatRoomId;
}