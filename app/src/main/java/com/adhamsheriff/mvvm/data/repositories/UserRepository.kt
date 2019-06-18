package com.adhamsheriff.mvvm.data.repositories

import androidx.lifecycle.MutableLiveData
import com.adhamsheriff.mvvm.data.network.MyApi
import com.adhamsheriff.mvvm.data.network.responses.AuthResponses
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String): Response<AuthResponses> {
        val loginResponse = MutableLiveData<String>()

        return MyApi().userLogin(email, password)

    }
}