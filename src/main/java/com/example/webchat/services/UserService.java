package com.example.webchat.services;

import com.example.webchat.models.UserModel;

public interface UserService {
    UserModel createUser(UserModel user);
    UserModel getCurrentUser();
}
