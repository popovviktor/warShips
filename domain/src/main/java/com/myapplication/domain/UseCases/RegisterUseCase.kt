package com.myapplication.domain.UseCases

import com.myapplication.data.api.repository.RepositoryImpl
import com.myapplication.data.api.models.RegisterReceive
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private var repositoryImpl: RepositoryImpl) {
    suspend fun invoke(body:RegisterReceive) =repositoryImpl.register(body)
}