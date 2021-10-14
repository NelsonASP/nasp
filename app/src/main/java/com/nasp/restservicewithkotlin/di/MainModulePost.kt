package com.nasp.restservicewithkotlin.di

import android.app.Activity
import com.nasp.restservicewithkotlin.model.MainInteractorImplPost
import com.nasp.restservicewithkotlin.model.MainInteractorPost
import com.nasp.restservicewithkotlin.presenter.MainPresenterImplPos
import com.nasp.restservicewithkotlin.presenter.MainPresenterPos
import com.nasp.restservicewithkotlin.view.ActivityPosts
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class MainModulePost {

    /* @Binds
     abstract fun bindMainActivity(
         mainActivity: MainActivity
     ): MainView*/

    @Binds
    abstract fun bindMainPresenter(
        mainPresenterImplPos: MainPresenterImplPos
    ): MainPresenterPos


    @Binds
    abstract fun bindMainInteractor(
        mainInteractorImplPost: MainInteractorImplPost
    ): MainInteractorPost
}

@InstallIn(ActivityComponent::class)
@Module
object MainActivityModulePost {

    @Provides
    fun bindActivity(activity: Activity): ActivityPosts {
        return activity as ActivityPosts
    }
}