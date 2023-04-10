package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class AutoLoginTokenReceive(
    @SerializedName("token" ) var token : String? = null,
    @SerializedName("login" ) var login : String? = null

)
