package com.myapplication.data.storage

import com.myapplication.data.api.models.AutoLoginTokenReceive
import com.myapplication.data.api.models.AutoLoginTokenResponse
import com.myapplication.data.api.models.LoginReceive
import com.myapplication.data.api.models.LoginResponse

interface AutoLoginStorage {
    fun saveToken(token:String):Boolean
    fun getToken():String
    fun saveLoginAndInfo(tokenResponse: AutoLoginTokenResponse):Boolean
    fun getLoginAndInfo():AutoLoginTokenResponse
}