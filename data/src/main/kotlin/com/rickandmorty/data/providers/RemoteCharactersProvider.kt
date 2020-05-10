package com.rickandmorty.data.providers

import com.rickandmorty.data.models.CharacterEntity
import io.reactivex.Single

interface RemoteCharactersProvider {
    suspend fun characters(page : Int): List<CharacterEntity>
}