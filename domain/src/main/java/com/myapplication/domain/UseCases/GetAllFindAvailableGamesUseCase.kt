package com.myapplication.domain.UseCases

import com.myapplication.data.repository.RepositoryImpl
import javax.inject.Inject

class GetAllFindAvailableGamesUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend fun invoke() = repositoryImpl.getAllFindGames()
}