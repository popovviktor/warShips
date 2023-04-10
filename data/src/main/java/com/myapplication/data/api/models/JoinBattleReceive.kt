package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class JoinBattleReceive(
    @SerializedName("token1" ) var token1 : String? = null,
    @SerializedName("token2" ) var token2 : String? = null,
    @SerializedName("idbattle" ) var idbattle : String? = null
)