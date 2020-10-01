package com.example.rvmvvmkotlin.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rvmvvmkotlin.Model.ReqresUser
import com.example.rvmvvmkotlin.data.repositories.UserRepository

class RecyclerViewModel: ViewModel() {

    var responseLiveData = MutableLiveData<ReqresUser>()

    fun getPost(){
        responseLiveData = UserRepository().recyclerData()
    }
}