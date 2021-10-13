package com.nasp.restservicewithkotlin

import com.nasp.restservicewithkotlin.entities.PostDataCollectionItem
import com.nasp.restservicewithkotlin.entities.UserDataCollectionItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface UserService {
    @GET("users")
    fun listUsers(): Observable<ArrayList<UserDataCollectionItem>>

    @GET("posts")
    fun listPost(): Observable<ArrayList<PostDataCollectionItem>>
}