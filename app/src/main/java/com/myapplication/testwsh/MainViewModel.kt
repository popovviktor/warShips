package com.myapplication.testwsh

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.data.api.models.CreateBattleResponse
import com.myapplication.data.api.models.CreateBattleTokenReceive
import com.myapplication.data.api.models.FindGamesResponse
import com.myapplication.data.utils.NetworkResult
import com.myapplication.domain.UseCases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getallfindgamesUseCase:GetAllFindAvailableGamesUseCase,
    private val createBattleUseCase: CreateBattleUseCase,
    private val joinBattleUseCase: JoinBattleUseCase,
    private val loadforstepgoneUseCase:LoadForGoneStepUseCase,
    private val shootInTheBattleUseCase: ShootInTheBattleUseCase,
    private val waitWinorLoseUseCase: WaitWinorLoseUseCase,

    ):ViewModel(){
    private val _battle_id = MutableLiveData<NetworkResult<CreateBattleResponse>>()
    val battle_id:LiveData<NetworkResult<CreateBattleResponse>>
        get() = _battle_id
    fun createBattle(token:String){
        viewModelScope.launch {
            createBattleUseCase.invoke(CreateBattleTokenReceive(token = token))?.let {
                _battle_id.value = it
            }
        }
    }
    //find available games
    private val _allfindgames = MutableLiveData<NetworkResult<FindGamesResponse>>()
    val allFindGames: LiveData<NetworkResult<FindGamesResponse>>
        get() = _allfindgames
    fun getAllFindGames(){
        viewModelScope.launch {
            getallfindgamesUseCase.invoke()?.let {
                _allfindgames.value = it
            }
        }
    }
}
