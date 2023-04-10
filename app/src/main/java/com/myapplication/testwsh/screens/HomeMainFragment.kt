package com.myapplication.testwsh.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myapplication.testwsh.R
import com.myapplication.testwsh.databinding.FragmentHomeBinding
import com.myapplication.testwsh.screens.navfragments.HomeFragment

class HomeMainFragment : Fragment() {
    lateinit var binding:FragmentHomeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

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
        fun newInstance() = HomeMainFragment()
    }
    fun init(){
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.mainFrame, HomeFragment())
            ?.commit()
    }
}