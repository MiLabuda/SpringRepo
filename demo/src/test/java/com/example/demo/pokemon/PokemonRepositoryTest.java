package com.example.demo.pokemon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class PokemonRepositoryTest {

    @Autowired
    private PokemonRepository pokemonRepository;

    @BeforeEach
    void initUseCase() {
        List<Pokemon> pokemons = Arrays.asList(
                new Pokemon(12345L, "Pikachu", "Electric", "Static", 5, 100, 35, 55, 40, 90, "Kanto", "Ash"),
                new Pokemon(67890L, "Charmander", "Fire", "Blaze", 5, 100, 40, 35, 65, 90, "Kanto", "Ash"),
                new Pokemon(13579L, "Squirtle", "Water", "Torrent", 5, 100, 40, 40, 40, 90, "Kanto", "Ash")
        );

        pokemonRepository.saveAll(pokemons);
    }

    @AfterEach
    void cleanUseCase() {
        pokemonRepository.deleteAll();
    }

    @Test
    void saveAll() {
        List<Pokemon> pokemons = Arrays.asList(
                new Pokemon(24680L, "Bulbasaur", "Grass", "Overgrow", 5, 100, 40, 40, 40, 90, "Kanto", "Ash"),
                new Pokemon(98765L, "Charmeleon", "Fire", "Blaze", 5, 100, 58, 55, 80, 90, "Kanto", "Ash"),
                new Pokemon(54321L, "Wartortle", "Water", "Torrent", 5, 100, 58, 58, 58, 90, "Kanto", "Ash")
        );
        Iterable<Pokemon> allPokemons = pokemonRepository.saveAll(pokemons);
        AtomicInteger countValidIds = new AtomicInteger();
        allPokemons.forEach(pokemon -> {
            if (pokemon.getId() != null) {
                countValidIds.getAndIncrement();
            }
        });

        assert(countValidIds.get() == 3);
    }

    @Test
    void findAll_success() {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        assert(pokemons.size() == 3);
    }


    @Test
    void findById_success() {
        Pokemon pokemon = pokemonRepository.findById(12345L).orElse(null);
        assert(pokemon != null);
    }

    @Test
    void findById_failure() {
        Pokemon pokemon = pokemonRepository.findById(123456L).orElse(null);
        assert(pokemon == null);
    }

}
