package com.example.goldsgym.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "gyms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "manager_name")
    private String managerName;

    @OneToMany(mappedBy = "gym")
    private List<User> users;

    // Optional: Add methods to update fields if needed
    public void updateManagerName(String managerName) {
        this.managerName = managerName;
    }
}

