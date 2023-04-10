package com.myapplication.testwsh.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.myapplication.testwsh.MainActivity
import com.myapplication.testwsh.R
import com.myapplication.testwsh.ViewModelRegisterLoginToken
import com.myapplication.testwsh.databinding.FragmentRegisterCreatePasswordBinding
import com.myapplication.testwsh.screens.navfragments.HomeFragment

class RegisterCreatePasswordFragment : Fragment() {
    private val vmreg: ViewModelRegisterLoginToken by activityViewModels()
    lateinit var binding: FragmentRegisterCreatePasswordBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnsave.setOnClickListener {
            if (correctpasswords()){
                funclickSave()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterCreatePasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegisterCreatePasswordFragment()
    }
    fun correctpasswords():Boolean{
        val password1 = binding.editPasswordFirst.text.toString()
        val password2 = binding.editPasswordSecond.text.toString()
        if (password1.length>4 && password1 == password2){
            return true
        }else{
            Toast.makeText(activity,"Пароли некорректны",Toast.LENGTH_SHORT).show()
            return false
        }
    }
    fun initstateAfterReg(){
        val botmenu =activity?.findViewById<BottomNavigationView>(R.id.bottomNavMenu)
        botmenu?.visibility = View.VISIBLE
        activity?.findNavController(R.id.nav_host)?.popBackStack()
        activity?.findNavController(R.id.nav_host)?.navigate(R.id.homeFragment)
    }
    fun funclickSave(){
        val password = binding.editPasswordFirst.text.toString()
        val namesAndLogin =vmreg.regUserStepOne.value!!
        vmreg.register(login = namesAndLogin.email,
            password = password,
            firstname = namesAndLogin.firstname,
            lastname = namesAndLogin.lastname)
        vmreg.myToken.observe(requireActivity() as MainActivity, Observer {
            if (it.data!=null){
                initstateAfterReg()
            }
        })
    }
}