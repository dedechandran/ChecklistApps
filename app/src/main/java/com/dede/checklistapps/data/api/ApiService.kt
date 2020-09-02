package com.dede.checklistapps.data.api

import com.dede.checklistapps.data.domain.User
import com.dede.checklistapps.data.domain.UserLogin
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("/register")
    suspend fun registerUser(@Body user : User)

    @POST("/login")
    suspend fun loginUser(@Body user : UserLogin)
}