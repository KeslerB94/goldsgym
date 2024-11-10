package com.example.goldsgym.services;

import com.example.goldsgym.dtos.GymDto;
import com.example.goldsgym.models.Gym;
import com.example.goldsgym.repositories.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {

    @Autowired
    private GymRepository gymRepository;

    public Gym createGym(Gym gym) {
        return gymRepository.save(gym);
    }

    public Gym getGymById(int id) {
        return gymRepository.findById(id).orElse(null);
    }

    public List<Gym> getAllGyms() {
        return gymRepository.findAll();
    }

    public Gym updateGym(int id, GymDto gymDto) {
        Gym gym = gymRepository.findById(id).orElse(null);

        if (gym != null) {
            gym.setAddress(gymDto.getAddress());
            gym.setManagerName(gymDto.getManagerName());
            return gymRepository.save(gym);
        }
        return null;
    }

    public void deleteGymById(int id) {
        gymRepository.deleteById(id);
    }
}
