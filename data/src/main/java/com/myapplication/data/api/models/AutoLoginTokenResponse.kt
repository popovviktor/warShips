package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class AutoLoginTokenResponse (
    @SerializedName("login"    ) var login    : String? = null,
    @SerializedName("firstname"    ) var firstname    : String? = null,
    @SerializedName("lastname" ) var lastname : String? = null
        )