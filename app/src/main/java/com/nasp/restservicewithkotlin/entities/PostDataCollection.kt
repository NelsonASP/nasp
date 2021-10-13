package com.nasp.restservicewithkotlin.entities

class PostoDataCollection : ArrayList<PostDataCollectionItem>()

data class PostDataCollectionItem(
    val id: Int,
    val userId: String,
    val title: String,
    val body: String
)