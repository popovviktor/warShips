package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class FindEmailResponse(
    @SerializedName("result" ) var result:String
)
