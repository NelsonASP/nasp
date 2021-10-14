package com.nasp.restservicewithkotlin.model

import com.nasp.restservicewithkotlin.entities.PostDataCollectionItem
import com.nasp.restservicewithkotlin.entities.UserDataCollectionItem
import io.reactivex.rxjava3.core.Observer

interface MainInteractorPost {

    fun listPost(subscriber: Observer<ArrayList<PostDataCollectionItem>>)
}