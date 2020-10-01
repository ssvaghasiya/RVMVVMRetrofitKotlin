package com.example.rvmvvmkotlin.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rvmvvmkotlin.Model.Data
import com.example.rvmvvmkotlin.Model.ExampleItem
import com.example.rvmvvmkotlin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.example_item.view.*

class ExampleAdapter(private val dataList: MutableList<Data>): RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        context = parent.context
        var itemview = LayoutInflater.from(parent.context).inflate(R.layout.example_item,parent,false)
        return ExampleViewHolder(
            itemview
        )
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        var currentitem = dataList[position]

        holder.textView1.text = currentitem.email
        holder.textview2.text = currentitem.first_name
//        holder.imageView.setImageResource(currentitem.imageResource)
//        Glide.with(context).load(currentitem.avatar).into(holder.imageView)
        Picasso.get().load("${currentitem.avatar}").into(holder.imageView)

        holder.itemView.setOnClickListener {
            Toast.makeText(context,currentitem.first_name, Toast.LENGTH_SHORT).show()
        }
    }

    class ExampleViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){

        val imageView: ImageView = itemview.image_view
        val textView1: TextView = itemview.text_view_1
        val textview2: TextView = itemview.text_view_2
    }
}