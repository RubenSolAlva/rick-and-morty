package com.rickandmorty.di.modules

import com.rickandmorty.BuildConfig
import com.rickandmorty.data.providers.RemoteCharactersProvider
import com.rickandmorty.remote.providers.RemoteCharactersProviderImp
import dagger.Module
import dagger.Provides
import com.rickandmorty.remote.services.RemoteServiceConfig
import dagger.Binds
import kotlinx.serialization.ImplicitReflectionSerializer
import javax.inject.Singleton

@Module
abstract class RemoteModule {
    /**
     * This companion object annotated as a module is necessary in order to provide dependencies
     * statically in case the wrapping module is an abstract class (to use binding)
     */
    @Module
    companion object {
        @Provides
        @JvmStatic
        @Singleton
        fun provideRemoteServiceConfig(): RemoteServiceConfig = RemoteServiceConfig(
            baseUrl = BuildConfig.BASE_URL,
            debug = BuildConfig.DEBUG
        )
    }

    @ImplicitReflectionSerializer
    @Binds
    abstract fun bindCharactersProvider(remoteCharactersProviderImp: RemoteCharactersProviderImp): RemoteCharactersProvider

   }