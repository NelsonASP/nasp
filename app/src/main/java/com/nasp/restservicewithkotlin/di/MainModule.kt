package com.nasp.restservicewithkotlin.di

import android.app.Activity
import com.nasp.restservicewithkotlin.model.MainInteractor
import com.nasp.restservicewithkotlin.model.MainInteractorImpl
import com.nasp.restservicewithkotlin.presenter.MainPresenter
import com.nasp.restservicewithkotlin.presenter.MainPresenterImpl
import com.nasp.restservicewithkotlin.view.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class MainModule {

    /* @Binds
     abstract fun bindMainActivity(
         mainActivity: MainActivity
     ): MainView*/

    @Binds
    abstract fun bindMainPresenter(
        mainPresenterImpl: MainPresenterImpl
    ): MainPresenter


    @Binds
    abstract fun bindMainInteractor(
        mainInteractorImpl: MainInteractorImpl
    ): MainInteractor
}

@InstallIn(ActivityComponent::class)
@Module
object MainActivityModule {

    @Provides
    fun bindActivity(activity: Activity): MainActivity {
        return activity as MainActivity
    }
}