package com.rickandmorty.scenes.authentication

import androidx.lifecycle.LiveData
import io.reactivex.Observable
import com.rickandmorty.common.BaseViewModel
import com.rickandmorty.common.SingleLiveEvent
import javax.inject.Inject

class SignInSignUpViewModel @Inject constructor(
) : BaseViewModel<SignInSignUpViewModel.Input, SignInSignUpViewModel.Output>() {
    override fun transform(input: Input): Output {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    data class Input(
        val emailObservable: Observable<String>,
        val passwordObservable: Observable<String>,
        val singInTrigger: Observable<Unit>
    )

    data class Output(
        val response: LiveData<Boolean>,
        val backgroundWorkingProgress: LiveData<Boolean>,
        val errorMessage: SingleLiveEvent<Int>
    )
}

