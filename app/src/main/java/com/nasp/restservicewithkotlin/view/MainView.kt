package com.nasp.restservicewithkotlin.view

import com.nasp.restservicewithkotlin.entities.PostDataCollectionItem
import com.nasp.restservicewithkotlin.entities.UserDataCollectionItem

interface MainView {

    fun showResult(result: ArrayList<UserDataCollectionItem>)
    fun errorResult(t: String)
    fun showResult2(result: ArrayList<PostDataCollectionItem>)
    fun errorResult2(t: String)
}