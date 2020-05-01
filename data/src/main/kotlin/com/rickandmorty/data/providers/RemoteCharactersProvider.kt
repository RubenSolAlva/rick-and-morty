package com.rickandmorty.data.providers

import com.rickandmorty.data.model.response.CharacterEntity
import io.reactivex.Single

interface RemoteCharactersProvider {
    fun characters(page : Int): Single<List<CharacterEntity>>
}