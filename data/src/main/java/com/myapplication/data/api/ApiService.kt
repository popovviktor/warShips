package com.myapplication.data.api

import com.myapplication.data.api.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/findgames")
    suspend fun getAllAvailableGames():Response<FindGamesResponse>

    @POST("/register")
    suspend fun register(@Body body: RegisterReceive):Response<LoginResponse>
    @POST("/login")
    suspend fun login(@Body body: LoginReceive):Response<LoginResponse>

    @POST("/autologintoken")
    suspend fun autoLoginWithToken(@Body body: AutoLoginTokenReceive):Response<AutoLoginTokenResponse>

    @POST("/refreshtoken")//Once in 24 hours
    suspend fun refreshToken(@Body body: RefreshTokenRecieve):Response<RefreshTokenResponse>
    @POST("/createbattle")
    suspend fun createBattle(@Body body: CreateBattleTokenReceive):Response<CreateBattleResponse>
    @POST("/joinbattle")
    suspend fun joinInBattle(@Body body: JoinBattleReceive):Response<JoinBattleResponse>
    @POST("/shoot")
    suspend fun shootInTheBattle(@Body body: ShootReceive):Response<ShootResponse>
    @POST("/waitwinlose")
    suspend fun waitwinlose(@Body body: WaitWinLoseReceive):Response<WaitWinLoseResponse>
    @POST("/loadstep")
    suspend fun loadstep(@Body body:LoadStepRecieve):Response<LoadStepResponse>
    @POST("/registerfindlogin")
    suspend fun findemailindb(@Body body: FindEmailReceive):Response<FindEmailResponse>
    }
