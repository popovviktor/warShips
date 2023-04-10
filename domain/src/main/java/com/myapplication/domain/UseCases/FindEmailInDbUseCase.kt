package com.myapplication.domain.UseCases

import com.myapplication.data.repository.RepositoryImpl
import com.myapplication.data.api.models.FindEmailReceive
import javax.inject.Inject

class FindEmailInDbUseCase @Inject constructor(private val repositoryImpl: RepositoryImpl) {
    suspend fun invoke(body:FindEmailReceive) = repositoryImpl.findemailindb(body)
}