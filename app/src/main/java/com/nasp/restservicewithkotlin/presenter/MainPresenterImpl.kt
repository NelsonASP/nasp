package com.nasp.restservicewithkotlin.presenter

import com.nasp.restservicewithkotlin.entities.PostDataCollectionItem
import com.nasp.restservicewithkotlin.entities.UserDataCollectionItem
import com.nasp.restservicewithkotlin.model.DefaultObserver
import com.nasp.restservicewithkotlin.model.MainInteractor
import com.nasp.restservicewithkotlin.view.MainActivity
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val view: MainActivity,
    private val interactor: MainInteractor
) : MainPresenter {

    override fun listUsers() {
        interactor.listUsers(MainObserver())
    }

    override fun listPost() {
        interactor.listPost(MainObserver2())
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

    inner class MainObserver2 : DefaultObserver<ArrayList<PostDataCollectionItem>>() {

        override fun onNext(n: ArrayList<PostDataCollectionItem>?) {
            dispose()
            view?.showResult2(n!!)
        }

        override fun onError(e: Throwable?) {
            view?.errorResult2(e?.message.toString())
        }
    }

}