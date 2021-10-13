package com.nasp.restservicewithkotlin.model

import com.nasp.restservicewithkotlin.RestEngine
import com.nasp.restservicewithkotlin.UserService
import com.nasp.restservicewithkotlin.entities.PostDataCollectionItem
import com.nasp.restservicewithkotlin.entities.UserDataCollectionItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class MainInteractorImpl @Inject constructor(
) : MainInteractor {

    override fun listUsers(subscriber: Observer<ArrayList<UserDataCollectionItem>>) {
        RestEngine.getRestEngine().create(UserService::class.java).listUsers()
            .subscribeOn(Schedulers.newThread())
            //.map { it.filter { it.name == "Leanne Graham" } } Para filtrar datos en caso que sea necesario
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(subscriber)
    }

    override fun listPost(subscriber: Observer<ArrayList<PostDataCollectionItem>>) {
        RestEngine.getRestEngine().create(UserService::class.java).listPost()
            .subscribeOn(Schedulers.newThread())
            //.map { it.filter { it.name == "Leanne Graham" } } Para filtrar datos en caso que sea necesario
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(subscriber)
    }
}