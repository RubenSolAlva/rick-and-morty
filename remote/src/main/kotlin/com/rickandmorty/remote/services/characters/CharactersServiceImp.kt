package com.rickandmorty.remote.services.characters

import com.rickandmorty.remote.models.NWCharactersResponse
import com.rickandmorty.remote.services.RemoteService
import com.rickandmorty.remote.services.RemoteServiceConfig
import io.reactivex.Single
import kotlinx.serialization.ImplicitReflectionSerializer
import javax.inject.Inject


@ImplicitReflectionSerializer
class CharactersServiceImp @Inject constructor(private val serviceConfig: RemoteServiceConfig) :
    RemoteService<CharactersService>(CharactersService::class.java, serviceConfig) {
    fun characters(page : Int): Single<NWCharactersResponse> {
        return service.characters(page)
    }
}