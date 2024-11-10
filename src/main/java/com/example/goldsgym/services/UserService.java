package com.example.goldsgym.services;

import com.example.goldsgym.models.User;

public interface UserService {
    User createUser(User users);
    User getUserById(int id);
    User updateUserAddress(int id, String address);
}