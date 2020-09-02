package com.dede.checklistapps.data.repository

import com.dede.checklistapps.data.api.ApiHelper
import com.dede.checklistapps.data.domain.User
import javax.inject.Inject

class RegisterRepository @Inject constructor(private val apiHelper : ApiHelper){
    suspend fun registerUser(user : User){
        apiHelper.registerUser(user)
    }
}