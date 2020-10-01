package com.example.rvmvvmkotlin.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rvmvvmkotlin.Model.ReqresUser
import com.example.rvmvvmkotlin.data.network.MyApi
import com.example.rvmvvmkotlin.data.network.SafeApiRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class UserRepository(private val api: MyApi): SafeApiRequest(){
//    suspend fun getData() = apiRequest { api.getData() }
//}

class UserRepository
{

    fun recyclerData() : MutableLiveData<ReqresUser>{
        val recResponse = MutableLiveData<ReqresUser>()

        MyApi().getData()
            .enqueue(object : Callback<ReqresUser>{
                override fun onFailure(call: Call<ReqresUser>, t: Throwable) {
                    Log.d("SAVAN","Error",t)
                }

                override fun onResponse(call: Call<ReqresUser>, response: Response<ReqresUser>) {
                    if(response.isSuccessful){
                        recResponse.value = response.body()
                        Log.d("APIRESPONSEFROM",response.body().toString())
                    }
                }
            })
        return recResponse
    }
}