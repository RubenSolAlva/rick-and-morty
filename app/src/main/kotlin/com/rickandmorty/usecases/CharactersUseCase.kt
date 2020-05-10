package com.rickandmorty.usecases

import com.rickandmorty.data.repositories.characters.CharactersRepository
import com.rickandmorty.mappers.asUIEntity
import com.rickandmorty.models.UICharacter
import javax.inject.Inject

class CharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    suspend fun execute(page: Int): List<UICharacter> =
        charactersRepository.characters(page).asUIEntity()
}