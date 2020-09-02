package com.dede.checklistapps.data.api

import com.dede.checklistapps.data.domain.User
import com.dede.checklistapps.data.domain.UserLogin

interface ApiHelper {
    suspend fun registerUser(user : User)
    suspend fun loginUser(user : UserLogin)
}