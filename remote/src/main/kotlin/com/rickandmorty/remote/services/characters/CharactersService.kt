package com.rickandmorty.remote.services.characters

import com.rickandmorty.remote.models.NWCharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val CHARACTERS_PATH = "/api/character"
const val PAGE_PATH = "page"

interface CharactersService {
    @GET(CHARACTERS_PATH)
    suspend fun characters(@Query(PAGE_PATH) page: Int): NWCharactersResponse
}