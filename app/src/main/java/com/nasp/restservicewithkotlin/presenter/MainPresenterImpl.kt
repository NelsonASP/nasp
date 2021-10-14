package com.nasp.restservicewithkotlin.presenter

import com.nasp.restservicewithkotlin.entities.PostDataCollectionItem
import com.nasp.restservicewithkotlin.entities.UserDataCollectionItem
import com.nasp.restservicewithkotlin.model.DefaultObserver
import com.nasp.restservicewithkotlin.model.MainInteractor
import com.nasp.restservicewithkotlin.view.ActivityPosts
import com.nasp.restservicewithkotlin.view.MainActivity
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val view: MainActivity,
    private val interactor: MainInteractor
) : MainPresenter {

    override fun listUsers() {
        interactor.listUsers(MainObserver())
    }


    inner class MainObserver : DefaultObserver<ArrayList<UserDataCollectionItem>>() {

        override fun onNext(t: ArrayList<UserDataCollectionItem>?) {
            dispose()
            view?.showResult(t!!)
        }

        override fun onError(e: Throwable?) {
            view?.errorResult(e?.message.toString())
        }
    }
}