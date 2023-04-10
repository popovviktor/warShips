package com.myapplication.data.repository

import com.myapplication.data.api.RemoteDataSource
import com.myapplication.data.api.models.*
import com.myapplication.data.utils.BaseApiResponse
import com.myapplication.data.utils.NetworkResult
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource):BaseApiResponse(){

    suspend fun getAllFindGames():NetworkResult<FindGamesResponse>{
        return  safeApiCall { remoteDataSource.getAllAvailableGames() }
    }
    suspend fun register(body:RegisterReceive):NetworkResult<LoginResponse>{
        return safeApiCall { remoteDataSource.register(body = body) }
    }
    suspend fun login(body:LoginReceive):NetworkResult<LoginResponse>{
        return safeApiCall { remoteDataSource.login(body = body) }
    }
    suspend fun autologinwithtoken(body:AutoLoginTokenReceive):NetworkResult<AutoLoginTokenResponse>{
        return safeApiCall { remoteDataSource.autologintoken(body = body) }
    }
    suspend fun refreshtoken(body:RefreshTokenRecieve):NetworkResult<RefreshTokenResponse>{
        return safeApiCall { remoteDataSource.refreshtoken(body = body) }
    }
    suspend fun createbattle(body: CreateBattleTokenReceive):NetworkResult<CreateBattleResponse>{
        return safeApiCall { remoteDataSource.createbattle(body=body) }
    }
    suspend fun joinbattle(body: JoinBattleReceive):NetworkResult<JoinBattleResponse>{
        return safeApiCall { remoteDataSource.joinbattle(body = body) }
    }
    suspend fun shootinthebattle(body:ShootReceive):NetworkResult<ShootResponse>{
        return safeApiCall { remoteDataSource.shootinbattle(body = body) }
    }
    suspend fun waitwinorlose(body:WaitWinLoseReceive):NetworkResult<WaitWinLoseResponse>{
        return safeApiCall { remoteDataSource.waitwinorlose(body = body) }
    }
    suspend fun loadforstepdone(body:LoadStepRecieve):NetworkResult<LoadStepResponse>{
        return safeApiCall { remoteDataSource.loadstep(body = body) }
    }
    suspend fun findemailindb(body:FindEmailReceive):NetworkResult<FindEmailResponse>{
        return safeApiCall { remoteDataSource.findemailindb(body = body) }
    }
}