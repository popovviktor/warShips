package com.myapplication.testwsh

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.api.models.AutoLoginTokenReceive
import com.myapplication.data.api.models.AutoLoginTokenResponse
import com.myapplication.data.utils.NetworkResult
import com.myapplication.domain.UseCases.AutoTokenLoginUseCase
import com.myapplication.domain.UseCases.usecasesAutoLogin.GetLoginAndInfoStorageUseCase
import com.myapplication.domain.UseCases.usecasesAutoLogin.GetTokenStorageUseCase
import com.myapplication.domain.UseCases.usecasesAutoLogin.SaveLoginAndInfoStorageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


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
    private val _myToken = MutableLiveData<String>()
        val myToken:LiveData<String>
            get() = _myToken
    private val _mylogin = MutableLiveData<String>()
    val mylogin:LiveData<String>
        get() = _mylogin
    private val _responseAutoLog = MutableLiveData<NetworkResult<AutoLoginTokenResponse>>()
        val responseAutoLog:LiveData<NetworkResult<AutoLoginTokenResponse>>
            get() = _responseAutoLog
    suspend fun getToken(){
        getTokenStorageUseCase.invoke().let {
            _myToken.value = it
        }

    }




}