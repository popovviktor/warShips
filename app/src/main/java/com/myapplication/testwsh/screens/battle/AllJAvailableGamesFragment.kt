package com.myapplication.testwsh.screens.battle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.data.api.models.ArrayInFindGamesResponse
import com.myapplication.testwsh.MainActivity
import com.myapplication.testwsh.MainViewModel
import com.myapplication.testwsh.R
import com.myapplication.testwsh.ViewModelRegisterLoginToken
import com.myapplication.testwsh.databinding.FragmentAllJAvailableGamesBinding
import com.myapplication.testwsh.screens.battle.adapters.AdapterForAllJoinGames

class AllJAvailableGamesFragment : Fragment(),AdapterForAllJoinGames.OnJoinBattleClickListener {
    private val adapterFindGames = AdapterForAllJoinGames()
    private val vmreg: ViewModelRegisterLoginToken by activityViewModels()
    lateinit var binding:FragmentAllJAvailableGamesBinding
    private val vmbattle: MainViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vmbattle.getAllFindGames()

        vmbattle.allFindGames.observe(requireActivity() as MainActivity, Observer {
            var arr = it.data?.battles
            if (arr!= null){
                for (elem in arr){
                    System.out.println(elem)
                }
                var grid = GridLayoutManager(activity,1, RecyclerView.VERTICAL,false)
                binding.rvitemsFindGames.layoutManager = grid
                adapterFindGames.battles = arr
                adapterFindGames.onJoinBattleClickListener = this
                binding.rvitemsFindGames.adapter = adapterFindGames
            }

        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllJAvailableGamesBinding.inflate(layoutInflater)
        return binding.root }

    companion object {
        @JvmStatic
        fun newInstance() = AllJAvailableGamesFragment()
            }

    override fun onJoinThisBattle(item: ArrayInFindGamesResponse) {
        System.out.println(item)
    }

}
