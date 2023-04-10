package com.myapplication.testwsh.screens.navfragments

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.myapplication.testwsh.R
import com.myapplication.testwsh.databinding.FragmentHomeBinding
import com.myapplication.testwsh.screens.LoginFragment
import com.myapplication.testwsh.screens.battle.CreateGameFragment


class HomeFragment : Fragment() {
   lateinit var binding:FragmentHomeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCreateGame.setOnClickListener {
            funclickcreategame()
        }
        binding.btnAllJoin.setOnClickListener {

        }
    }
   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
    fun funclickcreategame(){
        activity?.findNavController(R.id.nav_host)?.navigate(R.id.createGameFragment)
    }
}