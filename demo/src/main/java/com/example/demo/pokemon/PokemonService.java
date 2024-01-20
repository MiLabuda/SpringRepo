package com.example.demo.pokemon;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface PokemonService {

    List<PokemonDTO> getAllPokemon();

    PokemonDTO getPokemonDTOByIdOrThrow(Long id);

    Pokemon getPokemonByIdOrThrow(Long id);

    PokemonDTO createPokemon(PokemonForm pokemonForm);

    PokemonDTO partialUpdatePokemon(Long id, Map<String, Object> updates);

    PokemonDTO updatePokemon(Long id, PokemonDTO pokemonDTO);

    void deletePokemon(Long id);

}
