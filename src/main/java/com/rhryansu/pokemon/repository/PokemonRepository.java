package com.rhryansu.pokemon.repository;

import com.rhryansu.pokemon.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
