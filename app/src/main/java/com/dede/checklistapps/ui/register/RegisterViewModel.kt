package com.dede.checklistapps.ui.register

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dede.checklistapps.data.domain.User
import com.dede.checklistapps.data.repository.RegisterRepository
import com.dede.checklistapps.utils.Resource
import kotlinx.coroutines.Dispatchers

class RegisterViewModel @ViewModelInject constructor(private val registerRepository: RegisterRepository) :
    ViewModel() {

    fun registerUser(user: User) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            registerRepository.registerUser(user)
            emit(Resource.success(data = null))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Register Failed"))
        }
    }
}