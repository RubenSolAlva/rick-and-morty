package com.mobilechallenge.di.modules

import com.mobilechallenge.BuildConfig
import dagger.Module
import dagger.Provides
import com.mobilechallenge.remote.services.RemoteServiceConfig
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
            appVersion = "test-version",
            debug = BuildConfig.DEBUG
        )
    }

   }