package com.myapplication.domain.UseCases.usecasesAutoLogin

import com.myapplication.data.api.models.AutoLoginTokenResponse
import com.myapplication.data.api.repository.RepositoryImpl
import javax.inject.Inject

class GetLoginAndInfoStorageUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend fun invoke():AutoLoginTokenResponse{
        return repositoryImpl.getLoginAndIngo()
    }
}