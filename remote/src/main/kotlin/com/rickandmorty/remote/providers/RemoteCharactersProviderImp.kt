package com.rickandmorty.remote.providers

import com.rickandmorty.data.models.CharacterEntity
import com.rickandmorty.data.providers.RemoteCharactersProvider
import com.rickandmorty.remote.extensions.parseError
import com.rickandmorty.remote.mappers.asDataEntity
import com.rickandmorty.remote.services.RemoteService
import com.rickandmorty.remote.services.RemoteServiceConfig
import com.rickandmorty.remote.services.characters.CharactersService
import io.reactivex.Single
import kotlinx.serialization.ImplicitReflectionSerializer
import javax.inject.Inject

@ImplicitReflectionSerializer
class RemoteCharactersProviderImp @Inject constructor(serviceConfig: RemoteServiceConfig) :
    RemoteService<CharactersService>(CharactersService::class.java, serviceConfig), RemoteCharactersProvider {
    override suspend fun characters(page : Int): List<CharacterEntity> {
        return service.characters(page).results.asDataEntity()
    }
}