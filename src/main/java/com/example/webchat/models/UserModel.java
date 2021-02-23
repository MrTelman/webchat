package com.example.webchat.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String login;

    private String password;

    private boolean active;
}

