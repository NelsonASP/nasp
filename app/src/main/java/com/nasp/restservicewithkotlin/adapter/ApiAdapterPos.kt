package com.nasp.restservicewithkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nasp.restservicewithkotlin.R
import com.nasp.restservicewithkotlin.entities.PostDataCollectionItem

import kotlinx.android.synthetic.main.item_api.view.*
import kotlinx.android.synthetic.main.item_api_post.view.*

class ApiAdapterPos(
    private val users : ArrayList<PostDataCollectionItem>): RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_api_post, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is ItemViewHolder -> holder.bind(users[position], position)
            else -> throw IllegalArgumentException("Error")
        }

    }

    override fun getItemCount(): Int = users.size


    inner class ItemViewHolder(itemView: View): BaseViewHolder<PostDataCollectionItem>(itemView){
        override fun bind(item: PostDataCollectionItem, position: Int) {
           itemView.title.text = item.title
           itemView.body.text = item.body
        }
    }
}

