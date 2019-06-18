package com.adhamsheriff.mvvm.ui.auth

import androidx.lifecycle.LiveData
import com.adhamsheriff.mvvm.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
    }