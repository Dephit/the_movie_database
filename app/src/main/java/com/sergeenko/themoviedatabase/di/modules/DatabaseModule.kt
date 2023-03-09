package com.sergeenko.themoviedatabase.di.modules

import com.sergeenko.data.genres.GenreDatabase
import com.sergeenko.data.movies.database.MovieDataBase
import com.sergeenko.data.tv.database.TvDatabase
import com.sergeenko.domain.genre.IGenreDatabase
import com.sergeenko.domain.movie.IMovieDatabase
import com.sergeenko.domain.tv.ITvDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule{

    @Provides
    fun provideMovieDataBase(): IMovieDatabase = MovieDataBase()

    @Provides
    fun provideTvDatabase(): ITvDatabase = TvDatabase()

    @Provides
    fun provideGenreDatabase(): IGenreDatabase = GenreDatabase()


}