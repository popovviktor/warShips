package com.myapplication.testwsh.screens.battle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.myapplication.data.api.models.AutoLoginTokenReceive
import com.myapplication.data.api.models.LoginReceive
import com.myapplication.testwsh.MainActivity
import com.myapplication.testwsh.MainViewModel
import com.myapplication.testwsh.R
import com.myapplication.testwsh.ViewModelRegisterLoginToken
import com.myapplication.testwsh.databinding.FragmentCreateGameBinding


class CreateGameFragment : Fragment() {
    private val vmreg: ViewModelRegisterLoginToken by activityViewModels()
    private val vmbattle:MainViewModel by activityViewModels()
    lateinit var binding:FragmentCreateGameBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createBattle()
        vmbattle.battle_id.observe(requireActivity() as MainActivity, Observer {
            binding.textinfo.text = "БИТВА СОЗДАНААААА!"
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateGameBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
       @JvmStatic
        fun newInstance() = CreateGameFragment()
            }
    fun createBattle(){
        val mytoken = vmreg.token.value.toString()
        val mylogin = vmreg.mylogin.value.toString()
        vmbattle.createBattle(login = mylogin, token = mytoken)
    }
    }
