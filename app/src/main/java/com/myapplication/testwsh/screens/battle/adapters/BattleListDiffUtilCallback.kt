package com.myapplication.testwsh.screens.battle.adapters

import androidx.recyclerview.widget.DiffUtil
import com.myapplication.data.api.models.ArrayInFindGamesResponse

class BattleListDiffUtilCallback(
    private val oldList:ArrayList<ArrayInFindGamesResponse>,
    private val newList:ArrayList<ArrayInFindGamesResponse>
):DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val olditem = oldList.get(oldItemPosition)
        val newitem = newList.get(newItemPosition)
        return olditem.id == newitem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val olditem = oldList.get(oldItemPosition)
        val newitem = newList.get(newItemPosition)
        return olditem == newitem
    }
}