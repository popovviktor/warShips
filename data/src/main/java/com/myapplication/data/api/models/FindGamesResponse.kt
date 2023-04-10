package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class FindGamesResponse(
    @SerializedName("battles") var battles:ArrayList<ArrayInFindGamesResponse>,


)
data class ArrayInFindGamesResponse(
    @SerializedName("id"     ) var id     : String? = null,
    @SerializedName("login1" ) var login1 : String? = null,
    @SerializedName("token1" ) var token1 : String? = null,
    @SerializedName("token2" ) var token2 : String? = null
)
