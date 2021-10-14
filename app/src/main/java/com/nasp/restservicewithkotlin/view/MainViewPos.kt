package com.nasp.restservicewithkotlin.view

import com.nasp.restservicewithkotlin.entities.PostDataCollectionItem
import com.nasp.restservicewithkotlin.entities.UserDataCollectionItem

interface MainViewPos {

    fun showResult(result: ArrayList<PostDataCollectionItem>)
    fun errorResult(t: String)
}