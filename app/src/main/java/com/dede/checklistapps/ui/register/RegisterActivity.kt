package com.dede.checklistapps.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.dede.checklistapps.R
import com.dede.checklistapps.data.domain.User
import com.dede.checklistapps.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private val registerViewModel : RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()

    }


    private fun init(){
        setupUi()
    }

    private fun setupUi(){
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }

        btnRegisterNow.setOnClickListener {
            val userName = fieldRegisterUsername.text.toString()
            val userPassword = fieldRegisterPassword.text.toString()
            val userEmail = fieldRegisterEmail.text.toString()
            val userData = User(userEmail,userPassword,userName)
            setupObservers(userData)
        }
    }

    private fun setupObservers(user : User){
        registerViewModel.registerUser(user).observe(this, Observer {
            it?.let { resource ->
                when(resource.status){
                    Status.SUCCESS -> {
                        Toast.makeText(this,"Register Success",Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        Toast.makeText(this,"Waiting for Response",Toast.LENGTH_LONG).show()
                    }
                    Status.ERROR -> {
                        Toast.makeText(this,resource.message,Toast.LENGTH_LONG).show()
                    }
                }
            }
        })
    }
}