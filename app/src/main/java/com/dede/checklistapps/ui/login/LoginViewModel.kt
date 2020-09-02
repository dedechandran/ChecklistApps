package com.dede.checklistapps.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dede.checklistapps.data.domain.UserLogin
import com.dede.checklistapps.data.repository.LoginRepository
import com.dede.checklistapps.utils.Resource

class LoginViewModel @ViewModelInject constructor(private val loginRepository: LoginRepository) : ViewModel() {
    fun loginUser(user : UserLogin) = liveData {
        emit(Resource.loading(data = null))
        try {
            loginRepository.loginUser(user)
            emit(Resource.success(data = null))
        }catch (e : Exception){
            emit(Resource.error(data = null, message = e.message ?: "Login Failed"))
        }
    }
}