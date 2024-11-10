package com.example.goldsgym.controllers;

import com.example.goldsgym.dtos.GymDto;
import com.example.goldsgym.models.Gym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gyms")
public class GymController {

    @Autowired
    private com.example.goldsgym.services.GymService gymService;

    @PostMapping
    public Gym createGym(@RequestBody Gym gym) {
        return gymService.createGym(gym);
    }

    @GetMapping("/{id}")
    public Gym getGymById(@PathVariable int id) {
        return gymService.getGymById(id);
    }

    @GetMapping
    public List<Gym> getAllGyms() {
        return gymService.getAllGyms();
    }

    @PutMapping("/{id}")
    public Gym updateGym(@PathVariable int id, @RequestBody GymDto gymDto) {
        return gymService.updateGym(id, gymDto);
    }

    @DeleteMapping("/{id}")
    public void deleteGymById(@PathVariable int id) {
        gymService.deleteGymById(id);
    }
}
