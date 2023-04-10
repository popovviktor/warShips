package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class LoginReceive (
    @SerializedName("login"    ) var login    : String? = null,
    @SerializedName("password" ) var password : String? = null
        )