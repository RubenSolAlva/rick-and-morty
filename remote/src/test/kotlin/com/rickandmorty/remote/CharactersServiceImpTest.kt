package com.rickandmorty.remote

import com.rickandmorty.remote.services.RemoteServiceConfig
import com.rickandmorty.remote.services.characters.CharactersServiceImp
import kotlinx.serialization.ImplicitReflectionSerializer
import org.junit.Test


@ImplicitReflectionSerializer
class CharactersServiceImpTest {

    private lateinit var charactersService: CharactersServiceImp
    private val baseURL = "https://rickandmortyapi.com/"
    private val page = 1

    @Test
    fun should_do_get_characters_successfully() {

        val config = RemoteServiceConfig(
            baseUrl = baseURL,
            debug = true
        )
        charactersService = CharactersServiceImp(config)

        val response = charactersService.characters(page).test()

        response.assertNoErrors()
        response.assertValue { it.results.size > 0 }
    }
}