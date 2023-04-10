package com.myapplication.testwsh

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.api.models.*
import com.myapplication.data.utils.NetworkResult
import com.myapplication.domain.UseCases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModelRegisterLoginToken @Inject constructor(
    private val findEmailInDbUseCase: FindEmailInDbUseCase,
    private val registerUseCase: RegisterUseCase,
    private val autoTokenLoginUseCase: AutoTokenLoginUseCase,
    private val loginUseCase: LoginUseCase,
    private val refreshTokenUseCase: RefreshTokenUseCase,
):ViewModel() {
    //login
    private val _login = MutableLiveData<NetworkResult<LoginReceive>>()
    val login:LiveData<NetworkResult<LoginReceive>>
        get()= _login
    fun logIn(login: String,password: String){
        viewModelScope.launch {
            loginUseCase.invoke(LoginReceive(login = login,password = password))?.let {
                _myToken.value = it
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
            )?.let {
                _myToken.value = it
            }
        }
    }
}