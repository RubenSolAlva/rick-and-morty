package com.rickandmorty.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rickandmorty.di.Injectable
import com.rickandmorty.models.UICharacter
import com.rickandmorty.usecases.CharactersUseCase
import io.reactivex.disposables.Disposable
import javax.inject.Inject

open class CharactersViewModel @Inject constructor(
    private val charactersUserUseCase: CharactersUseCase
) : ViewModel(), Injectable {

    private val characterList = MutableLiveData<List<UICharacter>>()

    fun characters(page : Int): Disposable {
        return charactersUserUseCase.execute(page)
            .map {
                characterList.postValue(it)
            }
            .doOnError {}
            .subscribe()
    }
}