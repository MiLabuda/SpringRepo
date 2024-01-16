package com.example.demo.pokemon;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
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
