package com.rickandmorty.remote.services.characters

import com.rickandmorty.remote.models.NWCharactersResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

const val CHARACTERS_PATH = "/api/character"
const val PAGE_PATH = "page"

interface CharactersService {
    @GET(CHARACTERS_PATH)
    fun characters(@Query(PAGE_PATH) page: Int): Single<NWCharactersResponse>
}