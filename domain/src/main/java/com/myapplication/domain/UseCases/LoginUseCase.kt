package com.myapplication.domain.UseCases

import com.myapplication.data.api.repository.RepositoryImpl
import com.myapplication.data.api.models.LoginReceive
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend fun invoke(body:LoginReceive) = repositoryImpl.login(body)
}