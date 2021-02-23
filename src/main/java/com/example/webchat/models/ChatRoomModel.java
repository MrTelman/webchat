package com.example.webchat.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="chat_rooms")
public class ChatRoomModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
}
