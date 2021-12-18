package com.rhryansu.pokemon.controller;

import com.rhryansu.pokemon.entity.Pokemon;
import com.rhryansu.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @PostMapping("/pokemons")
    public Pokemon create(@RequestBody Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @GetMapping("/pokemons")
    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }

    @PutMapping("/pokemons/{pokemon_id}")
    public Pokemon update(@PathVariable("pokemon_id") Long pokemonId, @RequestBody Pokemon pokemonObject) {
        Pokemon pokemon = pokemonRepository.getById(pokemonId);
        pokemon.setName(pokemonObject.getName());
        pokemon.setPower(pokemonObject.getPower());
        return pokemonRepository.save(pokemon);
    }


    @DeleteMapping("/pokemons/{pokemon_id}")
    public void delete(@PathVariable("pokemon_id") Long pokemonId) {
        pokemonRepository.deleteById(pokemonId);
    }

    @GetMapping("/pokemons/{pokemon_id}")
    public Pokemon findByPokemonId(@PathVariable("pokemon_id") Long pokemonId) {
        return pokemonRepository.getById(pokemonId);
    }
}
