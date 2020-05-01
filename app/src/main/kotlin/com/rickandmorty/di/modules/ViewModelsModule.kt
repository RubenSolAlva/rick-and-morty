package com.mobilechallenge.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.mobilechallenge.common.ViewModelFactory
import com.mobilechallenge.di.ViewModelKey
import com.mobilechallenge.scenes.authentication.SignInSignUpViewModel


@Module
abstract class ViewModelsModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SignInSignUpViewModel::class)
    abstract fun bindSignInSignUpViewModel(signInSignUpViewModel: SignInSignUpViewModel): ViewModel

}