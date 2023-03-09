package com.sergeenko.themoviedatabase.di.modules

import com.sergeenko.data.auth.AuthApi
import com.sergeenko.data.auth.AuthRepository
import com.sergeenko.data.genres.GenreApi
import com.sergeenko.data.genres.GenreRepository
import com.sergeenko.data.movies.MovieApi
import com.sergeenko.data.movies.MovieRepository
import com.sergeenko.data.tv.TvRepository
import com.sergeenko.data.search.SearchApi
import com.sergeenko.data.search.SearchRepository
import com.sergeenko.data.tv.TvApi
import com.sergeenko.domain.auth.IAuthDatabase
import com.sergeenko.domain.auth.IAuthRepository
import com.sergeenko.domain.genre.IGenreDatabase
import com.sergeenko.domain.genre.IGenreRepository
import com.sergeenko.domain.movie.IMovieDatabase
import com.sergeenko.domain.movie.IMovieRepository
import com.sergeenko.domain.search.ISearchRepository
import com.sergeenko.domain.tv.ITvDatabase
import com.sergeenko.domain.tv.ITvRepository
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule{

    @Provides
    fun provideMovieRepository(
        movieApiService: MovieApi,
        movieDatabase: IMovieDatabase,
    ): IMovieRepository = MovieRepository(
        movieDatabase = movieDatabase,
        movieApi = movieApiService,
    )

    @Provides
    fun provideSearchRepository(
        searchApi: SearchApi
    ): ISearchRepository = SearchRepository(
        searchApi = searchApi
    )



    @Provides
    fun provideGenreRepository(
        genreApi: GenreApi,
        genreDatabase: IGenreDatabase
    ): IGenreRepository = GenreRepository(
        genreApi = genreApi,
        genreDatabase = genreDatabase
    )


    @Provides
    fun provideTvRepository(
        tvApi: TvApi,
        database: ITvDatabase
    ): ITvRepository = TvRepository(
        tvDatabase = database,
        tvApi = tvApi
    )


    @Provides
    fun provideAuthRepository(
        api: AuthApi,
        database: IAuthDatabase
    ): IAuthRepository = AuthRepository(
        api,
        database
    )
}


