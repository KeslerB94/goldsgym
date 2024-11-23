package com.example.goldsgym.services;

import com.example.goldsgym.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(int id);
    User createUser(User user);
    User updateUserAddress(int id, String address);
    List<User> getUsersByGymId(int gymId);
    User assignUserToGym(int userId, int gymId);
}
