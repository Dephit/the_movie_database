package com.sergeenko.themoviedatabase.di

object Dagger {

    fun create(): ApplicationComponent{
        return DaggerApplicationComponent.create()
    }
}