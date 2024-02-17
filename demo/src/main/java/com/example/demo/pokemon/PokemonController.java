package com.example.demo.pokemon;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/user")
    List<PokemonDTO> getAllPokemon(){
        return pokemonService.getAllPokemon();
    }

    @GetMapping("/user/{id}")
    PokemonDTO getAllPokemon(@PathVariable Long id){
        return pokemonService.getPokemonDTOByIdOrThrow(id);
    }

    @PostMapping("/admin")
    PokemonDTO createPokemon(@Valid @RequestBody PokemonForm pokemonForm){
        return pokemonService.createPokemon(pokemonForm);
    }

    @PatchMapping("/admin/{id}")
    PokemonDTO updatePokemon(@PathVariable Long id, Map<String, Object> updates){
        return pokemonService.partialUpdatePokemon(id, updates);
    }

    @PutMapping("/admin/{id}")
    PokemonDTO updatePokemon(@PathVariable Long id, PokemonDTO pokemonDTO){
        return pokemonService.updatePokemon(id, pokemonDTO);
    }

    @DeleteMapping("/admin/{id}")
    String deletePokemon(@PathVariable Long id){
        pokemonService.deletePokemon(id);
        return "Pokemon with id " + id + " deleted";
    }



}
