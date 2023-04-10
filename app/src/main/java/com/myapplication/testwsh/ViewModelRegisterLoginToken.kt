package com.myapplication.testwsh

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.api.models.*
import com.myapplication.data.utils.NetworkResult
import com.myapplication.domain.UseCases.*
import com.myapplication.domain.UseCases.usecasesAutoLogin.GetLoginAndInfoStorageUseCase
import com.myapplication.domain.UseCases.usecasesAutoLogin.GetTokenStorageUseCase
import com.myapplication.domain.UseCases.usecasesAutoLogin.SaveLoginAndInfoStorageUseCase
import com.myapplication.domain.UseCases.usecasesAutoLogin.SaveTokenStorageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModelRegisterLoginToken @Inject constructor(
    private val findEmailInDbUseCase: FindEmailInDbUseCase,
    private val registerUseCase: RegisterUseCase,
    private val getTokenStorageUseCase: GetTokenStorageUseCase,
    private val getLoginAndInfoStorageUseCase: GetLoginAndInfoStorageUseCase,
    private val autoTokenLoginUseCase: AutoTokenLoginUseCase,
    private val loginUseCase: LoginUseCase,
    private val refreshTokenUseCase: RefreshTokenUseCase,
    private val saveTokenStorageUseCase: SaveTokenStorageUseCase,
    private val saveLoginAndInfoStorageUseCase: SaveLoginAndInfoStorageUseCase,

):ViewModel() {
    //login
    private val _logInBool = MutableLiveData<Boolean>()
    val loginBool:LiveData<Boolean>
        get() = _logInBool
    private val _mylogin = MutableLiveData<String>()
    val mylogin:LiveData<String>
        get() = _mylogin
    private val _myFirstName = MutableLiveData<String>()
    val myFirstName:LiveData<String>
        get() = _myFirstName
    private val _myLastName = MutableLiveData<String>()
    val myLastName:LiveData<String>
        get() = _myLastName
    private val _responseAutoLog = MutableLiveData<NetworkResult<AutoLoginTokenResponse>>()
    val responseAutoLog:LiveData<NetworkResult<AutoLoginTokenResponse>>
        get() = _responseAutoLog
    private val _login = MutableLiveData<NetworkResult<LoginReceive>>()
    val login:LiveData<NetworkResult<LoginReceive>>
        get()= _login
    private val _token = MutableLiveData<String>()
        val token:LiveData<String>
            get() = _token
    fun logIn(login: String,password: String){
        viewModelScope.launch {
            loginUseCase.invoke(LoginReceive(login = login,password = password)).let {
                _myToken.value = it
                System.out.println("SSSSS")
                val token = it.data?.token.toString()
                System.out.println("SSSSS")
                saveTokenStorageUseCase.invoke(AutoLoginTokenReceive(token = token ,login = login))
                System.out.println(AutoLoginTokenReceive(token = token ,login = login))
                saveLoginAndInfoStorageUseCase.invoke(AutoLoginTokenResponse(login = login))
            }
        }
    }
    // token this account
    private val _myToken = MutableLiveData<NetworkResult<LoginResponse>>()
    val myToken:LiveData<NetworkResult<LoginResponse>>
        get() = _myToken
    // from fragmentReg to fragmentRegCreatePassword
    private val _regUserStepOne = MutableLiveData<UserNamesLogin>()
    val regUserStepOne:LiveData<UserNamesLogin>
        get() = _regUserStepOne
    fun getToken(){
        viewModelScope.launch {
        getTokenStorageUseCase.invoke().let {
            _token.value = it.token.toString()
            System.out.println("LS:DLAKS:LDASd")
            System.out.println(it.token.toString())

        }}
    }
    fun getLoginAndInfo(){
        viewModelScope.launch {
        getLoginAndInfoStorageUseCase.invoke().let {
            _mylogin.value = it.login.toString()
            _login.value?.data?.login = it.login.toString()
            _myFirstName.value = it.firstname.toString()
            _myLastName.value = it.lastname.toString()
        }}

    }
    fun saveNamesAndLogin(firstname: String,lastname: String,login:String){
        _regUserStepOne.value = UserNamesLogin(
            firstname = firstname,
            lastname = lastname,
            email = login)
    }
    //check email in db
    private val _findemailresult = MutableLiveData<NetworkResult<FindEmailResponse>>()
    val findemailresult:LiveData<NetworkResult<FindEmailResponse>>
        get() = _findemailresult
    fun funfindemailindb(login: String){
        viewModelScope.launch {
            findEmailInDbUseCase.invoke(FindEmailReceive(login = login))?.let {
                _findemailresult.value = it
            }
        }
    }
    fun clearstateemailfindindb(){
        _findemailresult.value?.data?.result = "null"
    }
    //step two - end registration
    fun register(login:String,password:String,firstname:String,lastname:String){
        viewModelScope.launch {
            registerUseCase.invoke(body = RegisterReceive(
                login = login,
                password = password,
                firstname = firstname,
                lastname = lastname)
            ).let {
                System.out.println(it.data?.token)
                System.out.println(it.data?.token)
                _myToken.value?.data?.token = it.data?.token.toString()
                saveTokenStorageUseCase.invoke(AutoLoginTokenReceive(token =it.data?.token.toString(),login = login ))
                System.out.println(myToken.value.toString())
                System.out.println(login)
                System.out.println(login)
                saveLoginAndInfoStorageUseCase.invoke(AutoLoginTokenResponse(
                    login,firstname,lastname
                ))
            }
        }
    }
    fun autologin(){
        viewModelScope.launch {
            val token = _token.value.toString()
            System.out.println(token)
            val login = _mylogin.value.toString()
            val recive = AutoLoginTokenReceive(token = token, login = login)
            autoTokenLoginUseCase.invoke(recive) .let {
                _responseAutoLog.value = it

            }
        }}
    init {
            getLoginAndInfo()
            getToken()
            System.out.println(myToken.value?.data?.token)
            System.out.println(mylogin.value.toString())

    }
}