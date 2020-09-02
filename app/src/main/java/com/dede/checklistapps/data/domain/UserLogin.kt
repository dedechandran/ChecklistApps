package com.dede.checklistapps.data.domain

import com.google.gson.annotations.SerializedName

data class UserLogin(
    @SerializedName("password")
    val userPassword: String,
    @SerializedName("username")
    val userName: String
)