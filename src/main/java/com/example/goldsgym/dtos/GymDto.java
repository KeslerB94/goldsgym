package com.example.goldsgym.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GymDto {
    private int id;
    private String address;
    private String managerName;
}
