package com.example.goldsgym.services.impl;

import com.example.goldsgym.models.Gym;
import com.example.goldsgym.models.User;
import com.example.goldsgym.repositories.GymRepository;
import com.example.goldsgym.repositories.UserRepository;
import com.example.goldsgym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GymRepository gymRepository;

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUserAddress(int id, String address) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setAddress(address);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public List<User> getUsersByGymId(int gymId) {
        return userRepository.findByGymId(gymId);
    }

    @Override
    public User assignUserToGym(int userId, int gymId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Gym> gymOpt = gymRepository.findById(gymId);

        if (userOpt.isPresent() && gymOpt.isPresent()) {
            User user = userOpt.get();
            Gym gym = gymOpt.get();
            user.setGym(gym);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User or Gym not found");
        }
    }
}
