package com.rickandmorty.di.modules.fragments

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.rickandmorty.ui.authentication.SignInSignUpFragment

@Module
abstract class AuthenticationActivityFragmentsBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeAuthSignInSignUpFragmentInjector(): SignInSignUpFragment
}