package com.rickandmorty.di.modules.fragments

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentsBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeCharactersFragmentInjector(): CharactersFragment
}