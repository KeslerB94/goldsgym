package com.example.goldsgym.services;

import com.example.goldsgym.models.User;
import com.example.goldsgym.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null); // returns null if not found
    }

    @Override
    public User updateUserAddress(int id, String address) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setAddress(address);
            return userRepository.save(user);
        }
        return null; // or handle the case where user is not found
    }
}
