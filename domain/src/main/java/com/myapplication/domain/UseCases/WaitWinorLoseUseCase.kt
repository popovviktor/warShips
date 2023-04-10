package com.myapplication.domain.UseCases

import com.myapplication.data.repository.RepositoryImpl
import com.myapplication.data.api.models.WaitWinLoseReceive
import javax.inject.Inject

class WaitWinorLoseUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
        suspend fun invoke(body:WaitWinLoseReceive) = repositoryImpl.waitwinorlose(body)
}