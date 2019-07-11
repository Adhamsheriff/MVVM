package com.adhamsheriff.mvvm.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.adhamsheriff.mvvm.R
import com.adhamsheriff.mvvm.data.db.entities.User
import com.adhamsheriff.mvvm.databinding.ActivityLoginBinding
import com.adhamsheriff.mvvm.util.hide
import com.adhamsheriff.mvvm.util.show
import com.adhamsheriff.mvvm.util.snackbar
import com.adhamsheriff.mvvm.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this

    }

    override fun onStarted() {
        progress_bar.show()

    }

    override fun onSuccess(user: User) {
        progress_bar.hide()

        root_layout.snackbar("${user.name} is Logged In")
        toast("${user.name} is Logged In")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
        toast(message)
    }

}
