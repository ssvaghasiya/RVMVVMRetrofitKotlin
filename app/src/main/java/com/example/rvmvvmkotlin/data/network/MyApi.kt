package com.example.rvmvvmkotlin.data.network

import com.example.rvmvvmkotlin.Model.ReqresUser
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://reqres.in"
interface MyApi {
    @GET("/api/users?page=2")
     fun getData(): Call<ReqresUser>

    companion object{
        operator fun invoke(): MyApi{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}