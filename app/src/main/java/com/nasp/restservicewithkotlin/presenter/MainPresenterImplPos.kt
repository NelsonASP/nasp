package com.nasp.restservicewithkotlin.presenter

import com.nasp.restservicewithkotlin.entities.PostDataCollectionItem
import com.nasp.restservicewithkotlin.model.DefaultObserver
import com.nasp.restservicewithkotlin.model.MainInteractorPost
import com.nasp.restservicewithkotlin.view.ActivityPosts

import javax.inject.Inject

class MainPresenterImplPos @Inject constructor(
    private val view: ActivityPosts,
    private val interactor: MainInteractorPost
) : MainPresenterPos {

    override fun listPosts() {
        interactor.listPost(MainObserver())
    }

    inner class MainObserver : DefaultObserver<ArrayList<PostDataCollectionItem>>() {

        override fun onNext(n: ArrayList<PostDataCollectionItem>?) {
            dispose()
            view?.showResult(n!!)
        }

        override fun onError(e: Throwable?) {
            view?.errorResult(e?.message.toString())
        }
    }

}