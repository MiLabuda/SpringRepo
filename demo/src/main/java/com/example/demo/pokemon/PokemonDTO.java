package com.example.demo.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PokemonDTO {

    private String name;
    private String type;
    private String abilities;
    private int level;
    private int healthPoints;
    private int attack;
    private int defense;
    private int speed;
    private int experience;
    private String region;
    private String trainer;
}
