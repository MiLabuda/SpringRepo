package com.example.demo.pokemon;

import com.example.demo.utils.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonMapper {

    public PokemonDTO pokemonToPokemonDTO(Pokemon pokemon){
       PokemonDTO pokemonDTO = new PokemonDTO();
       pokemonDTO.setName(pokemon.getName());
       pokemonDTO.setAbilities(pokemon.getAbilities());
       pokemonDTO.setType(pokemon.getType());
       pokemonDTO.setAttack(pokemon.getAttack());
       pokemonDTO.setDefense(pokemon.getDefense())  ;
    pokemonDTO.setHealthPoints(pokemon.getHealthPoints());
    pokemonDTO.setLevel(pokemon.getLevel());
    pokemonDTO.setSpeed(pokemon.getSpeed());
    pokemonDTO.setExperience(pokemon.getExperience());
    pokemonDTO.setRegion(pokemon.getRegion());
    pokemonDTO.setTrainer(pokemon.getTrainer());
    return pokemonDTO;
    }

    public List<PokemonDTO> pokemonListToPokemonDTOList(List<Pokemon> pokemons){
        List<PokemonDTO> pokemonDTOList = new ArrayList<>();
        for(Pokemon pokemon : pokemons){
            pokemonDTOList.add(pokemonToPokemonDTO(pokemon));
        }
        return pokemonDTOList;
    }


    public Pokemon pokemonDTOToPokemon(PokemonDTO pokemonDTO){
        Pokemon pokemon = new Pokemon();
        pokemon.setId(IdGenerator.generateId());
        pokemon.setName(pokemonDTO.getName());
        pokemon.setAbilities(pokemonDTO.getAbilities());
        pokemon.setType(pokemonDTO.getType());
        pokemon.setAttack(pokemonDTO.getAttack());
        pokemon.setDefense(pokemonDTO.getDefense())  ;
        pokemon.setHealthPoints(pokemonDTO.getHealthPoints());
        pokemon.setLevel(pokemonDTO.getLevel());
        pokemon.setSpeed(pokemonDTO.getSpeed());
        pokemon.setExperience(pokemonDTO.getExperience());
        pokemon.setRegion(pokemonDTO.getRegion());
        pokemon.setTrainer(pokemonDTO.getTrainer());
        return pokemon;
    }
}
