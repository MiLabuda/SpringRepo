package com.example.demo.pokemon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {

    @Mock
    private PokemonRepository pokemonRepository;
    @Mock
    private PokemonMapper pokemonMapper;

    PokemonService pokemonService;

    @BeforeEach
    void initUseCase() {
        pokemonService = new PokemonServiceImpl(pokemonRepository, pokemonMapper);
    }

    @Test
    public void createPokemon_Success() {
        // Given
        PokemonForm pokemonForm = new PokemonForm("Pikachu", "Electric", "Static", 5, 100, 35, 55, 40, 90, "Kanto", "Ash");
        Pokemon expectedPokemon = new Pokemon(12345L, "Pikachu", "Electric", "Static", 5, 100, 35, 55, 40, 90, "Kanto", "Ash");
        PokemonDTO expectedPokemonDTO = new PokemonDTO("Pikachu", "Electric", "Static", 5, 100, 35, 55, 40, 90, "Kanto", "Ash");

        when(pokemonMapper.pokemonFormToPokemon(pokemonForm)).thenReturn(expectedPokemon);
        when(pokemonRepository.save(expectedPokemon)).thenReturn(expectedPokemon);
        when(pokemonMapper.pokemonToPokemonDTO(expectedPokemon)).thenReturn(expectedPokemonDTO);

        // When
        PokemonDTO pokemonDTO = pokemonService.createPokemon(pokemonForm);

        // Then
        verify(pokemonMapper).pokemonFormToPokemon(pokemonForm);
        verify(pokemonRepository).save(expectedPokemon);
        verify(pokemonMapper).pokemonToPokemonDTO(expectedPokemon);

        // Add assertions based on your specific requirements
        assertNotNull(pokemonDTO);
        assertEquals("Pikachu", pokemonDTO.getName());
        // Add more assertions as needed
    }


}
