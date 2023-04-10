package com.myapplication.testwsh.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.myapplication.data.api.models.FindEmailResponse
import com.myapplication.data.api.models.UserNamesLogin
import com.myapplication.testwsh.MainActivity
import com.myapplication.testwsh.R
import com.myapplication.testwsh.ViewModelAutoLogin
import com.myapplication.testwsh.ViewModelRegisterLoginToken
import com.myapplication.testwsh.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private val vmreg: ViewModelRegisterLoginToken by activityViewModels()
    private val vmautologin: ViewModelAutoLogin by activityViewModels()
    lateinit var binding:FragmentRegisterBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vmautologin.invokeAutoLogin()
        initstate()
        binding.btnSignIN.setOnClickListener {
            if(notEmptyNames()){
                if (correctEmail()){
                    funClickBtnSign()
                }
            }else{ incorrectNames()}
        }
        binding.btnLogIN.setOnClickListener{
            funClickBtnLogin()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater)
        return binding.root
    }

    companion object {
         @JvmStatic
        fun newInstance() = RegisterFragment()
    }
    fun initstate(){
        var botmenu =activity?.findViewById<BottomNavigationView>(R.id.bottomNavMenu)
        botmenu?.visibility = View.INVISIBLE
    }
    fun notEmptyNames():Boolean{
        val firstname = binding.editFirstName.text.toString()
        val lastname = binding.editLastNAme.text.toString()
        return firstname.length>0 && lastname.length>0
    }
    fun incorrectNames(){
        Toast.makeText(activity,"Заполнены не все поля",Toast.LENGTH_SHORT).show()
    }
    fun correctEmail():Boolean{
        val login = binding.editEmail.text.toString()
        if (!login.contains("@")){
            Toast.makeText(activity,"Некорректный email",Toast.LENGTH_SHORT).show()
            return false}
        if (!login.contains(".")){
            Toast.makeText(activity,"Некорректный email",Toast.LENGTH_SHORT).show()
            return false}
        return true
    }
    fun saveNamesAndLogin(){
        val firstname = binding.editFirstName.text.toString()
        val lastname = binding.editLastNAme.text.toString()
        val login = binding.editEmail.text.toString()
        vmreg.saveNamesAndLogin(firstname = firstname,lastname = lastname,login = login)
    }
    fun funClickBtnSign(){
        vmreg.funfindemailindb(binding.editEmail.text.toString())
        vmreg.findemailresult.observe(requireActivity() as MainActivity, Observer {
            if (it.data?.result=="true"){
                saveNamesAndLogin()
            }
            if (it.data?.result=="false"){
                Toast.makeText(activity,"Данный email уже зарегестрирован",Toast.LENGTH_SHORT).show()}

        })
        vmreg.clearstateemailfindindb()
    }
    fun funClickBtnLogin(){
        activity?.findNavController(R.id.nav_host)?.popBackStack()
        activity?.findNavController(R.id.nav_host)?.navigate(R.id.loginFragment)
    }
}
