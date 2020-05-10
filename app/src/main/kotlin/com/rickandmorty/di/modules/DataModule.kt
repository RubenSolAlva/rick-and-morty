package com.rickandmorty.di.modules

import com.rickandmorty.data.repositories.characters.CharactersRepository
import com.rickandmorty.data.repositories.characters.DataCharactersRepository
import dagger.Binds
import dagger.Module


@Module
abstract class DataModule {
    /**
     * This companion object annotated as a module is necessary in order to provide dependencies
     * statically in case the wrapping module is an abstract class (to use binding)
     */
    @Module
    companion object {
        /**
        @Provides
        @JvmStatic
        fun provideSomething(): Something {
        return InstanceOfSomething
        }*/
    }

    @Binds
    abstract fun bindCharactersRepository(charactersRepository: DataCharactersRepository): CharactersRepository

   }