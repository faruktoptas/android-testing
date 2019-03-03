package me.toptas.unittest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginService {

    @GET("login")
    fun login(
        @Query("user") user: String,
        @Query("pass¬") pass: String
    ): Call<Login>
}