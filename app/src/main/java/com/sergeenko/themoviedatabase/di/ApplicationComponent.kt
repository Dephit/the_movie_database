package com.sergeenko.themoviedatabase.di;

import com.sergeenko.themoviedatabase.MainActivity
import com.sergeenko.themoviedatabase.di.modules.ApiModule
import com.sergeenko.themoviedatabase.di.modules.DatabaseModule
import com.sergeenko.themoviedatabase.di.modules.RepositoryModule
import com.sergeenko.themoviedatabase.di.modules.RetrofitModule
import com.sergeenko.themoviedatabase.screens.detailed_screen.DetailedFragment
import com.sergeenko.themoviedatabase.screens.home.HomePageFragment
import com.sergeenko.themoviedatabase.screens.profile.ProfileFragment
import com.sergeenko.themoviedatabase.screens.search.SearchFragment
import dagger.Component

@Component(modules = [
    RepositoryModule::class,
    RetrofitModule::class,
    DatabaseModule::class,
    ApiModule::class
])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(usernameFragment: HomePageFragment)
    fun inject(usernameFragment: DetailedFragment)
    fun inject(usernameFragment: SearchFragment)
    fun inject(usernameFragment: ProfileFragment)

}
