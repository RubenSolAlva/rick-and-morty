package com.rickandmorty.remote.services.products

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET

const val PRODUCTS_PATH = "/api/character"

interface ProductsService {
    @GET(PRODUCTS_PATH)
    fun products(): Single<ResponseBody>
}