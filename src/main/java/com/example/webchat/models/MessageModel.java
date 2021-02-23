package com.example.webchat.models;

import lombok.Data;

@Data
public class MessageModel {
    private String from;
    private String message;
}