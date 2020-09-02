package com.dede.checklistapps.data.domain

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("email")
    val userEmail : String,
    @SerializedName("password")
    val userPassword : String,
    @SerializedName("username")
    val userName : String
)