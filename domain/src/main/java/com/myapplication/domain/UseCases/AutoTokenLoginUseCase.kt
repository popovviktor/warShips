package com.myapplication.domain.UseCases

import com.myapplication.data.api.repository.RepositoryImpl
import com.myapplication.data.api.models.AutoLoginTokenReceive
import javax.inject.Inject

class AutoTokenLoginUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend fun invoke(body:AutoLoginTokenReceive) = repositoryImpl.autologinwithtoken(body)
}