package com.nasp.restservicewithkotlin.view

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nasp.restservicewithkotlin.R
import com.nasp.restservicewithkotlin.entities.UserDataCollectionItem
import kotlinx.android.synthetic.main.item_api.view.*

class ApiAdapter( val users : ArrayList<UserDataCollectionItem>): RecyclerView.Adapter<ApiAdapter.Apiholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Apiholder {
        val itemview  = LayoutInflater.from(parent.context).inflate(R.layout.item_api, parent, false)
        return Apiholder(itemview)
    }

    override fun onBindViewHolder(holder: Apiholder, position: Int) {
        val currentItem = users[position]
        d("Nelson", "TAG ${currentItem.name}")
        holder.tvname.text = currentItem.name
        holder.tvphone.text = currentItem.phone
        holder.tvemail.text = currentItem.email
    }

    override fun getItemCount(): Int = 10

    class Apiholder( view : View): RecyclerView.ViewHolder(view){
        val tvname : TextView = itemView.tvname
        val tvphone : TextView = itemView.phone
        val tvemail : TextView = itemView.email
    }

}

