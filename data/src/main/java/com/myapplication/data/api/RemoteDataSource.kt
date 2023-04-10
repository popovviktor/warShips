package com.myapplication.data.api

import com.myapplication.data.api.models.*
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService){
    suspend fun getAllAvailableGames() = apiService.getAllAvailableGames()
    suspend fun register(body: RegisterReceive) = apiService.register(body = body)
    suspend fun login(body: LoginReceive) = apiService.login(body = body)
    suspend fun autologintoken(body: AutoLoginTokenReceive) = apiService.autoLoginWithToken(body = body)
    suspend fun refreshtoken(body: RefreshTokenRecieve) = apiService.refreshToken(body = body)
    suspend fun createbattle(body: CreateBattleTokenReceive) = apiService.createBattle(body = body)
    suspend fun joinbattle(body: JoinBattleReceive) = apiService.joinInBattle(body = body)
    suspend fun shootinbattle(body: ShootReceive) = apiService.shootInTheBattle(body = body)
    suspend fun waitwinorlose(body: WaitWinLoseReceive) = apiService.waitwinlose(body = body)
    suspend fun loadstep(body:LoadStepRecieve) = apiService.loadstep(body = body)
    suspend fun findemailindb(body:FindEmailReceive) = apiService.findemailindb(body = body)
}