package com.example.goldsgym.services.impl;

import com.example.goldsgym.dtos.GymDto;
import com.example.goldsgym.models.Gym;
import com.example.goldsgym.repositories.GymRepository;
import com.example.goldsgym.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GymServiceImpl implements GymService {

    @Autowired
    private GymRepository gymRepository;

    @Override
    public Gym createGym(Gym gym) {
        // Saving a new gym to the database
        return gymRepository.save(gym);
    }

    @Override
    public Gym getGymById(int id) {
        // Retrieving a gym by its ID, throwing an exception if not found
        return gymRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Gym not found with ID: " + id));
    }

    @Override
    public List<Gym> getAllGyms() {
        // Retrieving all gyms from the database
        return gymRepository.findAll();
    }

    @Override
    public Gym updateGym(int id, GymDto gymDto) {
        // Retrieving the gym to update
        Gym gym = gymRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Gym not found with ID: " + id));

        // Updating the gym details
        gym.setAddress(gymDto.getAddress());
        gym.updateManagerName(gymDto.getManagerName());

        // Saving the updated gym back to the database
        return gymRepository.save(gym);
    }

    @Override
    public void deleteGymById(int id) {
        // Check if the gym exists before deleting it
        if (!gymRepository.existsById(id)) {
            throw new EntityNotFoundException("Gym not found with ID: " + id);
        }
        gymRepository.deleteById(id);
    }
}
