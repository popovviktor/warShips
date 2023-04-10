package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class WaitWinLoseResponse(
    @SerializedName("text" ) var text : String? = null
)