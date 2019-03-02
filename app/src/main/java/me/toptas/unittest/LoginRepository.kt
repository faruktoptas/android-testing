package me.toptas.unittest

import java.lang.Exception

class LoginRepositoryImpl : LoginRepository {

    override fun login(user: String, pass: String): ApiResponse<Login> {
        return if (user == "user" && pass == "pass") {
            ApiResponse(Login("123"))
        } else {
            ApiResponse(error = Exception("Wrong password"))
        }
    }
}

interface LoginRepository {
    fun login(user: String, pass: String): ApiResponse<Login>
}


data class Login(val token: String)

data class ApiResponse<T>(val success: T? = null, val error: Throwable? = null)