package com.example.dodopizza.net


import com.example.dodopizza.AdapterVp.login
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiRet {
    @POST("user/login")
    fun getAuth(@Body hashMap: HashMap<String,String>):Call<login>
}