package com.example.goldsgym.controllers;

import com.example.goldsgym.models.User;
import com.example.goldsgym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}/address")
    public User updateUserAddress(@PathVariable int id, @RequestBody String address) {
        return userService.updateUserAddress(id, address);
    }
}
