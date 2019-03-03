package me.toptas.unittest

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class LoginRepositoryImpl : LoginRepository {

    private val service: LoginService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://example.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(LoginService::class.java)
    }

    override fun login(user: String, pass: String, cb: LoginCallback) {
        service.login(user, pass)
            .enqueue(object : Callback<Login> {
                override fun onFailure(call: Call<Login>, t: Throwable) {
                    cb.fail(t)
                }

                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response.body() != null) {
                        cb.success(response.body()!!)
                    } else {
                        cb.fail(Exception(""))
                    }

                }
            })
    }
}

interface LoginRepository {
    fun login(user: String, pass: String, cb: LoginCallback)
}

interface LoginCallback {
    fun success(login: Login)
    fun fail(error: Throwable)
}


data class Login(val token: String)

data class ApiResponse<T>(val success: T? = null, val error: Throwable? = null)