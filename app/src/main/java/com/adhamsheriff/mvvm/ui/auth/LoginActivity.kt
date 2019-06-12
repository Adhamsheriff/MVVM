package com.adhamsheriff.mvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.adhamsheriff.mvvm.R
import com.adhamsheriff.mvvm.databinding.ActivityLoginBinding
import com.adhamsheriff.mvvm.util.toast

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this

    }

    override fun onStarted() {
        toast("Started")
    }

    override fun onSuccess() {
        toast("Success")
    }

    override fun onFailure(message: String) {
        toast(message)
    }

}
