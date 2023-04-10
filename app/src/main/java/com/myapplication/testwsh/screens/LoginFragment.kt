package com.myapplication.testwsh.screens

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentResultOwner
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.myapplication.testwsh.MainActivity
import com.myapplication.testwsh.R
import com.myapplication.testwsh.ViewModelRegisterLoginToken
import com.myapplication.testwsh.databinding.FragmentLoginBinding
import com.myapplication.testwsh.screens.navfragments.HomeFragment
import kotlin.math.log


class LoginFragment : Fragment() {
    private val vmreg: ViewModelRegisterLoginToken by activityViewModels()
    lateinit var binding:FragmentLoginBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSignIN4.setOnClickListener{
            funclickSign()
        }
        binding.btnlogin.setOnClickListener {
            funclickLogIn()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
    fun funclickSign(){
        activity?.findNavController(R.id.nav_host)?.popBackStack()
        activity?.findNavController(R.id.nav_host)?.navigate(R.id.registerFragment)
    }
    fun funclickLogIn(){
        val login = binding.editEmaillogin2.text.toString()
        val password = binding.editPasswordLogin.text.toString()
        vmreg.logIn(login = login,password = password)
        vmreg.myToken.observe(requireActivity() as MainActivity, Observer {
            if (it.data!=null){
                initstateAfterLogIn()
            }
        })
    }
    fun initstateAfterLogIn(){
        val botmenu =activity?.findViewById<BottomNavigationView>(R.id.bottomNavMenu)
        botmenu?.visibility = View.VISIBLE
        val navhost = activity?.findViewById<FragmentContainerView>(R.id.nav_host)
        navhost?.visibility = View.VISIBLE
        activity?.findNavController(R.id.nav_host)?.popBackStack()
        activity?.findNavController(R.id.nav_host)?.navigate(R.id.homeFragment)
    }
}


