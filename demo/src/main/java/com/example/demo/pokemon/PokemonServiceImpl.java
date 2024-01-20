package com.example.demo.pokemon;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PokemonServiceImpl implements PokemonService{

    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;

    @Override
    public List<PokemonDTO> getAllPokemon() {
        List<Pokemon> pokemonList = pokemonRepository.findAll();
        return pokemonMapper.pokemonListToPokemonDTOList(pokemonList);
    }

    @Override
    public PokemonDTO getPokemonDTOByIdOrThrow(Long id) {
        Pokemon pokemon = getPokemonByIdOrThrow(id);
        return pokemonMapper.pokemonToPokemonDTO(pokemon);
    }

    @Override
    public Pokemon getPokemonByIdOrThrow(Long id) {
        return pokemonRepository.findById(id).orElseThrow(() -> new RuntimeException("Pokemon with id " + id + " not found"));
    }

    @Transactional
    @Override
    public PokemonDTO createPokemon(PokemonForm pokemonForm) {
        Pokemon pokemon = pokemonMapper.pokemonFormToPokemon(pokemonForm);
        pokemonRepository.save(pokemon);
        return pokemonMapper.pokemonToPokemonDTO(pokemon);
    }

    @Transactional
    @Override
    public PokemonDTO partialUpdatePokemon(Long id, Map<String, Object> updates) {
        Pokemon pokemon = getPokemonByIdOrThrow(id);

        updates.forEach((key, value) -> {
            switch (key) {
                case "name" -> pokemon.setName((String) value);
                case "type" -> pokemon.setType((String) value);
                case "abilities" -> pokemon.setAbilities((String) value);
                case "level" -> pokemon.setLevel((Integer) value);
                case "healthPoints" -> pokemon.setHealthPoints((Integer) value);
                case "attack" -> pokemon.setAttack((Integer) value);
                case "defense" -> pokemon.setDefense((Integer) value);
                case "speed" -> pokemon.setSpeed((Integer) value);
                case "experience" -> pokemon.setExperience((Integer) value);
                case "region" -> pokemon.setRegion((String) value);
                case "trainer" -> pokemon.setTrainer((String) value);
                default -> throw new IllegalArgumentException("Invalid update key: " + key);
            }
        });

        pokemonRepository.save(pokemon);

        return pokemonMapper.pokemonToPokemonDTO(pokemon);
    }

    @Transactional
    @Override
    public PokemonDTO updatePokemon(Long id, PokemonDTO pokemonDTO) {
        Pokemon pokemon = pokemonMapper.pokemonDTOToPokemon(pokemonDTO);
        pokemon.setId(id);

        pokemonRepository.save(pokemon);

        return pokemonMapper.pokemonToPokemonDTO(pokemon);
    }

    @Transactional
    @Override
    public void deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
    }




}
