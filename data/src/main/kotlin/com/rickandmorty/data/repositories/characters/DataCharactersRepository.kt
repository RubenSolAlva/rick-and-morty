package com.rickandmorty.data.repositories.characters

import com.rickandmorty.data.model.response.CharacterEntity
import com.rickandmorty.data.providers.RemoteCharactersProvider
import io.reactivex.Single
import javax.inject.Inject

class DataCharactersRepository @Inject constructor(
    private val remoteProvider: RemoteCharactersProvider
) : CharactersRepository {
    override fun characters(page : Int): Single<List<CharacterEntity>> {
        return remoteProvider.characters(page)
    }
}