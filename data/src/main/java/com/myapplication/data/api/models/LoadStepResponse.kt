package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class LoadStepResponse(
    @SerializedName("text" ) var text : String? = null
)
