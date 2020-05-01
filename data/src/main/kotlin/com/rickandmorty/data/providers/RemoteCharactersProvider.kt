package com.rickandmorty.data.providers

import com.rickandmorty.data.models.CharacterEntity
import io.reactivex.Single

interface RemoteCharactersProvider {
    fun characters(page : Int): Single<List<CharacterEntity>>
}