package com.rickandmorty.usecases

import com.rickandmorty.common.executors.PostExecutionThread
import com.rickandmorty.data.repositories.characters.CharactersRepository
import com.rickandmorty.mappers.asUIEntity
import com.rickandmorty.models.UICharacter
import com.rickandmorty.remote.executors.JobExecutor
import io.reactivex.Single
import javax.inject.Inject

class CharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository,
    private val postExecutionThread: PostExecutionThread,
    private val jobExecutor: JobExecutor
) {
    fun execute(page: Int): Single<List<UICharacter>> =
        charactersRepository.characters(page)
            .map { it.asUIEntity() }
            .subscribeOn(jobExecutor.getScheduler())
            .observeOn(postExecutionThread.getScheduler())
}