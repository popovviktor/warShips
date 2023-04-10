package com.myapplication.domain.UseCases

import com.myapplication.data.api.repository.RepositoryImpl
import com.myapplication.data.api.models.CreateBattleTokenReceive
import javax.inject.Inject

class CreateBattleUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend fun invoke(body:CreateBattleTokenReceive) = repositoryImpl.createbattle(body)
}