package com.example.dodopizza.net


import com.example.dodopizza.AdapterVp.Login
import retrofit2.Call
import retrofit2.http.*

interface ApiRet {
    @POST("auth/login")
    fun login(@Body hashMap: HashMap<String, String>): Call<Login.Login>
}