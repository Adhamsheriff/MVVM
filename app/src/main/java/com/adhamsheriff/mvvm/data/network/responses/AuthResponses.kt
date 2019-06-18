package com.adhamsheriff.mvvm.data.network.responses

import com.adhamsheriff.mvvm.data.db.entities.User

class AuthResponses(

    val isSuccessfull: Boolean?,
    val message: String?,
    val user: User

)