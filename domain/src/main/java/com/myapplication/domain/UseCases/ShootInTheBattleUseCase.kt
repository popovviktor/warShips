package com.myapplication.domain.UseCases

import com.myapplication.data.repository.RepositoryImpl
import com.myapplication.data.api.models.ShootReceive
import javax.inject.Inject

class ShootInTheBattleUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend fun invoke(body:ShootReceive) = repositoryImpl.shootinthebattle(body)
}