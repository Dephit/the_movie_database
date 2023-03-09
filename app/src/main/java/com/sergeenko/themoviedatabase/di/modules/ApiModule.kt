package com.sergeenko.themoviedatabase.di.modules

import com.sergeenko.data.auth.AuthApi
import com.sergeenko.data.genres.GenreApi
import com.sergeenko.data.movies.MovieApi
import com.sergeenko.data.tv.TvApi
import com.sergeenko.data.retrofit.IRetrofitClient
import com.sergeenko.data.search.SearchApi
import dagger.Module
import dagger.Provides

@Module
class ApiModule{

    @Provides
    fun provideMovieApi(client: IRetrofitClient): MovieApi = client.create(MovieApi::class.java)

    @Provides
    fun provideSearchApi(client: IRetrofitClient): SearchApi = client.create(SearchApi::class.java)

    @Provides
    fun provideTvApi(client: IRetrofitClient): TvApi = client.create(TvApi::class.java)

    @Provides
    fun provideGenreApi(client: IRetrofitClient): GenreApi = client.create(GenreApi::class.java)

    @Provides
    fun provideAuthApi(client: IRetrofitClient): AuthApi = client.create(AuthApi::class.java)

}