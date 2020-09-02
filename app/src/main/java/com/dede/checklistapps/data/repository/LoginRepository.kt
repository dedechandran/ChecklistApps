package com.dede.checklistapps.data.repository

import com.dede.checklistapps.data.api.ApiHelper
import com.dede.checklistapps.data.domain.UserLogin
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun loginUser(user: UserLogin) {
        apiHelper.loginUser(user)
    }
}