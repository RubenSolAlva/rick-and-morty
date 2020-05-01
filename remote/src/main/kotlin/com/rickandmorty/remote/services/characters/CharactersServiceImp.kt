package com.rickandmorty.remote.services.products

import com.mobilechallenge.remote.entities.responses.NWProductsResponse
import com.mobilechallenge.remote.extensions.parseSuccessResponseGson
import com.mobilechallenge.remote.services.RemoteService
import com.mobilechallenge.remote.services.RemoteServiceConfig
import io.reactivex.Single
import kotlinx.serialization.ImplicitReflectionSerializer
import javax.inject.Inject


@ImplicitReflectionSerializer
class CharactersServiceImp @Inject constructor(private val serviceConfig: RemoteServiceConfig) :
    RemoteService<ProductsService>(ProductsService::class.java, serviceConfig) {
    fun products(): Single<NWProductsResponse> {
        return service.products()
            .map { response -> response.parseSuccessResponseGson(NWProductsResponse::class.java) }
            .doOnSuccess { success -> println("SUCCESS: $success") }
    }
}