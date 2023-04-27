package com.myapplication.testwsh.screens.battle.services

import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.myapplication.testwsh.MainViewModel
import kotlinx.coroutines.*
import java.security.Provider.Service

class ServiceLoadStepInBattle():android.app.Service() {
    private val corutinesScope = CoroutineScope(Dispatchers.Main)
    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        corutinesScope.launch {
            for (i in 0..100){
                delay(500)
                System.out.println(i.toString())
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onDestroy() {
        corutinesScope.cancel()
        super.onDestroy()
    }
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
    companion object{
        fun newInstance(context: Context):Intent{
            return Intent(context,ServiceLoadStepInBattle::class.java)
        }
    }
}