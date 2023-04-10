package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class ShootReceive(
    @SerializedName("token"       ) var token       : String? = null,
    @SerializedName("shootcoords" ) var shootcoords : String? = null,
    @SerializedName("tokenwar"    ) var tokenwar    : String? = null,
    @SerializedName("idbattle"    ) var idbattle    : String? = null,
)
