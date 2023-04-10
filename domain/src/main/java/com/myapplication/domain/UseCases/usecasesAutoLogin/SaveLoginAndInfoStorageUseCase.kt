package com.myapplication.domain.UseCases.usecasesAutoLogin

import com.myapplication.data.api.models.AutoLoginTokenResponse
import com.myapplication.data.api.repository.RepositoryImpl
import javax.inject.Inject

class SaveLoginAndInfoStorageUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend fun invoke(autoLoginTokenResponse: AutoLoginTokenResponse){
        repositoryImpl.saveLoginAndInfo(autoLoginTokenResponse)
    }
}