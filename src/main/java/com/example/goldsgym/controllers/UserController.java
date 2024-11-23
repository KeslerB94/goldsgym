package com.example.goldsgym.controllers;

import com.example.goldsgym.models.User;
import com.example.goldsgym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new User
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id).orElse(null); // Return null if not found
    }

    // Get users by Gym ID
    @GetMapping("/gym/{gymId}")
    public List<User> getUsersByGymId(@PathVariable int gymId) {
        return userService.getUsersByGymId(gymId);
    }

    // Assign User to a Gym
    @PostMapping("/{userId}/gym/{gymId}")
    public User assignUserToGym(@PathVariable int userId, @PathVariable int gymId) {
        return userService.assignUserToGym(userId, gymId);
    }

    // Update User Address
    @PutMapping("/{id}")
    public User updateUserAddress(@PathVariable int id, @RequestBody String address) {
        return userService.updateUserAddress(id, address);
    }
}
