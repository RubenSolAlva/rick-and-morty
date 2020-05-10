package com.rickandmorty.di.modules.fragments

import com.rickandmorty.ui.fragments.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentsBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragmentInjector(): MainFragment
}