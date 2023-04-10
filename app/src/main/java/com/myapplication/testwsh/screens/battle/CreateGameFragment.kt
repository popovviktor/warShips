package com.myapplication.testwsh.screens.battle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.myapplication.testwsh.MainViewModel
import com.myapplication.testwsh.R
import com.myapplication.testwsh.ViewModelRegisterLoginToken


class CreateGameFragment : Fragment() {
    private val vmreg: ViewModelRegisterLoginToken by activityViewModels()
    private val vmbattle:MainViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createBattle()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_game, container, false)
    }

    companion object {
       @JvmStatic
        fun newInstance() = CreateGameFragment()
            }
    fun createBattle(){
        val mytoken = vmreg.myToken.value?.data?.token.toString()
        vmbattle.createBattle(mytoken)
    }
    }
