package com.example.demo.pokemon;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PokemonForm {

    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Type is required")
    private String type;

    private String abilities;
    @Min(value = 1, message = "Level must be greater than 0")
    @Max(value = 99, message = "Level must be less than 99")
    private int level;
    @Min(value = 1, message = "Health Points must be greater than 0")
    private int healthPoints;
    @Min(value = 1, message = "Attack must be greater than 0")
    private int attack;
    @Min(value = 1, message = "Defense must be greater than 0")
    private int defense;
    @Min(value = 1, message = "Speed must be greater than 0")
    private int speed;
    @Min(value = 1, message = "Experience must be greater than 0")
    private int experience;
    @NotEmpty(message = "Region is required")
    private String region;

    private String trainer;
}
