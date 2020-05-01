package com.rickandmorty.remote.providers

import com.rickandmorty.data.models.CharacterEntity
import com.rickandmorty.data.providers.RemoteCharactersProvider
import com.rickandmorty.remote.mappers.asDataEntity
import com.rickandmorty.remote.services.characters.CharactersServiceImp
import io.reactivex.Single
import kotlinx.serialization.ImplicitReflectionSerializer
import javax.inject.Inject

@ImplicitReflectionSerializer
class RemoteCharactersProviderImp @Inject constructor(private val provider: CharactersServiceImp) :
    RemoteCharactersProvider {
    override fun characters(page : Int): Single<List<CharacterEntity>> {
        return provider.characters(page).map {
            it.results.asDataEntity() }
    }
}