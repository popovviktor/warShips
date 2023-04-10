package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class WaitWinLoseReceive(
    @SerializedName("token" ) var token : String? = null,
    @SerializedName("idbattle" ) var idbattle : String? = null
)
