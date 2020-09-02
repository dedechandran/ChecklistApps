package com.dede.checklistapps.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.dede.checklistapps.R
import com.dede.checklistapps.data.domain.UserLogin
import com.dede.checklistapps.ui.register.RegisterActivity
import com.dede.checklistapps.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val loginViewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init(){
        setupUi()
    }

    private fun setupUi(){
        btnLogin.setOnClickListener {
            val userName = fieldLoginUsername.text.toString()
            val userPassword = fieldLoginPassword.text.toString()
            val userLogin = UserLogin(userPassword,userName)
            setupObservers(userLogin)
        }
        btnRegister.setOnClickListener {
            Intent(this,RegisterActivity::class.java).run {
                startActivity(this)
            }
        }
    }

    private fun setupObservers(user : UserLogin){
        loginViewModel.loginUser(user).observe(this, Observer {
            it?.let { resource ->
                when(resource.status){
                    Status.SUCCESS -> {
                        Toast.makeText(this,"Login Success", Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        Toast.makeText(this,"Waiting for Response", Toast.LENGTH_LONG).show()
                    }
                    Status.ERROR -> {
                        Toast.makeText(this,resource.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }
}