package com.rickandmorty.data.repositories.characters

import com.rickandmorty.data.models.CharacterEntity

interface CharactersRepository {
    suspend fun characters(page : Int): List<CharacterEntity>
}