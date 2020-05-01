package com.rickandmorty.data.repositories.characters

import com.rickandmorty.data.model.response.CharacterEntity
import io.reactivex.Single

interface CharactersRepository {
    fun characters(page : Int): Single<List<CharacterEntity>>
}