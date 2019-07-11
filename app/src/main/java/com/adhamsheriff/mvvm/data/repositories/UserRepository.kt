package com.adhamsheriff.mvvm.data.repositories

import androidx.lifecycle.MutableLiveData
import com.adhamsheriff.mvvm.data.network.MyApi
import com.adhamsheriff.mvvm.data.network.SafeApiRequest
import com.adhamsheriff.mvvm.data.network.responses.AuthResponses
import retrofit2.Response

class UserRepository : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponses {
        val loginResponse = MutableLiveData<String>()
        return apiRequest { MyApi().userLogin(email, password) }
    }
}