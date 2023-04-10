package com.myapplication.domain.UseCases

import com.myapplication.data.api.repository.RepositoryImpl
import com.myapplication.data.api.models.JoinBattleReceive
import javax.inject.Inject

class JoinBattleUseCase @Inject constructor(private var repositoryImpl: RepositoryImpl) {
    suspend fun invoke(body:JoinBattleReceive) = repositoryImpl.joinbattle(body)
}