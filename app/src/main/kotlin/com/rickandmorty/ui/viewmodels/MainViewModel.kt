package com.rickandmorty.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.rickandmorty.common.Resource
import com.rickandmorty.usecases.CharactersUseCase
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

open class MainViewModel @Inject constructor(
    private val charactersUserUseCase: CharactersUseCase
) : ViewModel() {

    fun getCharacters() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = charactersUserUseCase.execute(1)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}