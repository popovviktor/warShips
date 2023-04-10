package com.myapplication.domain.UseCases.usecasesAutoLogin

import com.myapplication.data.api.models.AutoLoginTokenReceive
import com.myapplication.data.api.repository.RepositoryImpl
import javax.inject.Inject

class GetTokenStorageUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend fun invoke():AutoLoginTokenReceive{
        return repositoryImpl.getStorageToken()
    }
}