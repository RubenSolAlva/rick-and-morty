package com.rickandmorty.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.rickandmorty.di.modules.fragments.MainActivityFragmentsBuildersModule
import com.rickandmorty.ui.MainActivity
import com.rickandmorty.ui.splash.SplashActivity

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector(modules = [(MainActivityFragmentsBuildersModule::class)])
    abstract fun contributeMainActivityInjector(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivityInjector(): SplashActivity
}