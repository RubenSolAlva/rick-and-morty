package com.rickandmorty.remote

import com.rickandmorty.remote.providers.RemoteCharactersProviderImp
import com.rickandmorty.remote.services.RemoteServiceConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import kotlinx.serialization.ImplicitReflectionSerializer
import org.junit.After
import org.junit.Before
import org.junit.Test

@ImplicitReflectionSerializer
@ExperimentalCoroutinesApi
class CharactersServiceImpTest {

    private lateinit var remoteCharactersProviderImp: RemoteCharactersProviderImp
    private val baseURL = "https://rickandmortyapi.com/"
    private val page = 1
    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Before
    fun before() {
        Dispatchers.setMain(testDispatcher)
        val config = RemoteServiceConfig(
            baseUrl = baseURL,
            debug = true
        )
        remoteCharactersProviderImp = RemoteCharactersProviderImp(config)
    }

    @After
    fun after() {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun should_do_get_characters_successfully() = testScope.runBlockingTest {
            remoteCharactersProviderImp.characters(page)
    }
}