package com.rickandmorty.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.rickandmorty.common.ViewModelFactory
import com.rickandmorty.di.ViewModelKey
import com.rickandmorty.ui.viewmodels.CharactersViewModel

@Module
abstract class ViewModelsModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    abstract fun bindCharactersViewModel(charactersViewModel: CharactersViewModel): ViewModel

}