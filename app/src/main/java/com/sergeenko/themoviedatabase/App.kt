package com.sergeenko.themoviedatabase

import android.app.Application
import com.sergeenko.themoviedatabase.di.ApplicationComponent
import com.sergeenko.themoviedatabase.di.Dagger


class App: Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = Dagger.create()
    }
}