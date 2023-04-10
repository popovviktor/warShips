package com.myapplication.data.api.models

import com.google.gson.annotations.SerializedName

data class FindEmailReceive(
    @SerializedName("login" )val login:String
)