package com.example.goldsgym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.goldsgym.models.Gym;

@Repository
public interface GymRepository extends JpaRepository<Gym, Integer> {
}