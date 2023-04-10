package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class ShootResponse(
    @SerializedName("tokenowner"  ) var tokenowner  : String?  = null,
    @SerializedName("shootcoords" ) var shootcoords : String?  = null,
    @SerializedName("result") var result      : Boolean? = null,
    @SerializedName("idbattle") var idbattle      : Boolean? = null
)