package com.myapplication.domain.UseCases

import com.myapplication.data.api.repository.RepositoryImpl
import com.myapplication.data.api.models.RefreshTokenRecieve
import javax.inject.Inject

class RefreshTokenUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend fun invoke(body:RefreshTokenRecieve) = repositoryImpl.refreshtoken(body)
}