package com.rickandmorty.data.repositories.characters

import com.rickandmorty.data.models.CharacterEntity
import com.rickandmorty.data.providers.RemoteCharactersProvider
import javax.inject.Inject

class DataCharactersRepository @Inject constructor(
    private val remoteProvider: RemoteCharactersProvider
) : CharactersRepository {
    override suspend fun characters(page : Int): List<CharacterEntity> {
        return remoteProvider.characters(page)
    }
}