package com.myapplication.domain.UseCases

import com.myapplication.data.api.repository.RepositoryImpl
import com.myapplication.data.api.models.LoadStepRecieve
import javax.inject.Inject

class LoadForGoneStepUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend fun invoke(body:LoadStepRecieve) = repositoryImpl.loadforstepdone(body)
}