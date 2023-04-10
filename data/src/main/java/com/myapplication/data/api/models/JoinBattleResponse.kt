package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class JoinBattleResponse (
    @SerializedName("idbattle" ) var idbattle : String? = null
        )