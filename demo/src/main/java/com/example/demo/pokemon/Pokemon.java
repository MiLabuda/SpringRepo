package com.example.demo.pokemon;

import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Pokemon {

    @Id
    private Long id;
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
