package com.dede.checklistapps.data.api

import com.dede.checklistapps.data.domain.User
import com.dede.checklistapps.data.domain.UserLogin
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService : ApiService) : ApiHelper {
    override suspend fun registerUser(user : User) {
        apiService.registerUser(user)
    }

    override suspend fun loginUser(user: UserLogin) {
        apiService.loginUser(user)
    }
}