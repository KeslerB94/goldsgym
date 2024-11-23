package com.example.goldsgym.controllers;

import com.example.goldsgym.models.Gym;
import com.example.goldsgym.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gyms")
public class GymController {

    @Autowired
    private GymService gymService;

    // Get all gyms
    @GetMapping
    public List<Gym> getAllGyms() {
        return gymService.getAllGyms();
    }

    // Get gym by ID
    @GetMapping("/{id}")
    public Gym getGymById(@PathVariable int id) {
        return gymService.getGymById(id); // Return null if not found
    }
}
