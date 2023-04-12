package com.myapplication.testwsh.screens.battle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.myapplication.data.api.models.ArrayInFindGamesResponse
import com.myapplication.testwsh.R
import com.myapplication.testwsh.databinding.ItemRvAllJoinBattleBinding


class AdapterForAllJoinGames():RecyclerView.Adapter<AdapterForAllJoinGames.ViewHolderAllFindGames>() {
    var battles = ArrayList<ArrayInFindGamesResponse>()
        set(value){
            val callback = BattleListDiffUtilCallback(battles,value)
            val diffresult = DiffUtil.calculateDiff(callback)
            diffresult.dispatchUpdatesTo(this)
            field = value
        }
    var onJoinBattleClickListener:OnJoinBattleClickListener? = null

    class ViewHolderAllFindGames(item: View):RecyclerView.ViewHolder(item) {
    private val binding = ItemRvAllJoinBattleBinding.bind(item)
        fun bind(itemBattle:ArrayInFindGamesResponse){
            with(binding){
                idbattle.text = itemBattle.id
                tokenoponent.text = itemBattle.token1
                loginoponnt.text = itemBattle.login1
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAllFindGames {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_all_join_battle,parent,false)
        return ViewHolderAllFindGames(view)
    }

    override fun onBindViewHolder(holder: ViewHolderAllFindGames, position: Int) {
        holder.bind(battles.get(position))
        holder.itemView.setOnClickListener {
            onJoinBattleClickListener?.onJoinThisBattle(battles.get(position))
        }
    }

    override fun getItemCount(): Int {
        return battles.size
    }
    interface OnJoinBattleClickListener{
        fun onJoinThisBattle(item:ArrayInFindGamesResponse)
    }

}