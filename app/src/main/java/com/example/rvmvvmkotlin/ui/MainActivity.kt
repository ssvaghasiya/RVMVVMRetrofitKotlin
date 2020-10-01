package com.example.rvmvvmkotlin.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rvmvvmkotlin.Model.Data
import com.example.rvmvvmkotlin.Model.ExampleItem
import com.example.rvmvvmkotlin.Model.ReqresUser
import com.example.rvmvvmkotlin.R
import com.example.rvmvvmkotlin.ViewModel.RecyclerViewModel
import com.example.rvmvvmkotlin.data.network.MyApi
import com.example.rvmvvmkotlin.data.repositories.UserRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(){
    var dataList: MutableList<ExampleItem> = mutableListOf()
    lateinit var adapter: ExampleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(RecyclerViewModel::class.java)
//        dataList.add(
//            ExampleItem(
//                R.drawable.ic_launcher_background,
//                "123",
//                "31323"
//            )
//        )
        viewModel.getPost()
        viewModel.responseLiveData.observe(this, Observer {
            Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
            Log.d("TOASTOFREC",it.toString())
            var data: MutableList<Data> = it.data as MutableList<Data>
            adapter = ExampleAdapter(data)
            recycler_view.adapter = adapter
            recycler_view.layoutManager = LinearLayoutManager(this)
            recycler_view.setHasFixedSize(true)
        })
    }
}