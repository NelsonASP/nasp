package com.nasp.restservicewithkotlin.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.nasp.restservicewithkotlin.R
import com.nasp.restservicewithkotlin.entities.UserDataCollectionItem
import kotlinx.android.synthetic.main.item_api.view.*

class ApiAdapter(
    private val onItemClickListener:itemClickListener,
    private val users : ArrayList<UserDataCollectionItem>): RecyclerView.Adapter<BaseViewHolder<*>>(),Filterable {

    private var tempUsers = users

    interface itemClickListener{
        fun onItemClick(name: String, phone: String, email: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_api, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is ItemViewHolder -> holder.bind(tempUsers[position], position)
            else -> throw IllegalArgumentException("Error")
        }

    }

    override fun getItemCount(): Int = tempUsers.size


    inner class ItemViewHolder(itemView: View): BaseViewHolder<UserDataCollectionItem>(itemView){
        override fun bind(item: UserDataCollectionItem, position: Int) {
           itemView.tvname.text = item.name
           itemView.phone.text = item.phone
           itemView.email.text = item.email

           itemView.setOnClickListener { onItemClickListener.onItemClick(item.name, item.phone, item.email) }

        }
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(searchInfo: CharSequence?): FilterResults {
                var filterlist = ArrayList<UserDataCollectionItem>()
                if (searchInfo!!.isEmpty() || searchInfo.length == 0){

                    filterlist = users
                }else{
                    users.forEach { userDataCollectionItem ->
                        if (userDataCollectionItem.name.toLowerCase().contains(searchInfo.toString().toLowerCase())){
                            filterlist.add(userDataCollectionItem)
                        }
                    }
                }
                var filterResult = FilterResults()
                filterResult.values = filterlist
                return filterResult
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
               tempUsers = results!!.values as ArrayList<UserDataCollectionItem>
                notifyDataSetChanged()
            }

        }
    }
}

