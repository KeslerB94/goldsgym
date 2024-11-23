package com.example.goldsgym.services;

import com.example.goldsgym.dtos.GymDto;
import com.example.goldsgym.models.Gym;

import java.util.List;

public interface GymService {

    Gym createGym(Gym gym);

    Gym getGymById(int id);

    List<Gym> getAllGyms();

    Gym updateGym(int id, GymDto gymDto);

    void deleteGymById(int id);
}
