package com.sergeenko.themoviedatabase.di.modules

import com.sergeenko.data.retrofit.IRetrofitClient
import com.sergeenko.data.retrofit.RetrofitClient
import dagger.Module
import dagger.Provides


@Module
class RetrofitModule{

    @Provides
    fun provideRetrofitClient(): IRetrofitClient = RetrofitClient()

}