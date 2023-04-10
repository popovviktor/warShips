package com.myapplication.testwsh

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.api.models.AutoLoginTokenReceive
import com.myapplication.data.api.models.AutoLoginTokenResponse
import com.myapplication.domain.UseCases.AutoTokenLoginUseCase
import com.myapplication.domain.UseCases.usecasesAutoLogin.GetLoginAndInfoStorageUseCase
import com.myapplication.domain.UseCases.usecasesAutoLogin.GetTokenStorageUseCase
import com.myapplication.domain.UseCases.usecasesAutoLogin.SaveLoginAndInfoStorageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class ViewModelAutoLogin @Inject constructor(
    private val getTokenStorageUseCase: GetTokenStorageUseCase,
    private val getLoginAndInfoStorageUseCase: GetLoginAndInfoStorageUseCase,
    private val autoTokenLoginUseCase: AutoTokenLoginUseCase,
    private val saveLoginAndInfoStorageUseCase: SaveLoginAndInfoStorageUseCase
):ViewModel() {
    private val _logInBool = MutableLiveData<Boolean>()
        val loginBool:LiveData<Boolean>
            get() = _logInBool
    suspend fun getToken():String{
        return getTokenStorageUseCase.invoke()
    }
    suspend fun getLoginAndInfo():AutoLoginTokenResponse{
        return getLoginAndInfoStorageUseCase.invoke()
    }
    fun invokeAutoLogin(){
        viewModelScope.launch {
        val token = getToken()
        val loginAndInfo = getLoginAndInfo()
        val login = loginAndInfo.login
        val recive = AutoLoginTokenReceive(token = token, login = login)
        autoTokenLoginUseCase.invoke(recive) ?.let {
            if (it.data?.firstname != "firstname"){
                _logInBool.value = true
                val setFirstAndLastName= AutoLoginTokenResponse(login = login,
                    firstname = it.data?.firstname ,
                    lastname = it.data?.lastname)
                saveLoginAndInfoStorageUseCase.invoke(setFirstAndLastName)
            }
        }
    }}

}