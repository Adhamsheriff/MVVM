package com.adhamsheriff.mvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.adhamsheriff.mvvm.data.repositories.UserRepository
import com.adhamsheriff.mvvm.util.ApiException
import com.adhamsheriff.mvvm.util.Coroutines

class AuthViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid UserName or Password")
            return
        }

        Coroutines.main {
            try {
                val authResponses = UserRepository().userLogin(email!!, password!!)

                authResponses.user.let {
                    authListener?.onSuccess(it)
                    return@main
                }
                authListener?.onFailure(authResponses.message!!)

            }catch (e: ApiException){
                authListener?.onFailure(e.message!!)
            }

        }
    }
}