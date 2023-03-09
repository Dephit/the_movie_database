package com.sergeenko.themoviedatabase.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergeenko.data.tv.TvRepository
import com.sergeenko.domain.models.ErrorResponse
import com.sergeenko.domain.models.Response
import com.sergeenko.domain.models.ShowModel
import com.sergeenko.domain.movie.IMovieRepository
import com.sergeenko.domain.tv.ITvRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomePageState(
    val isLoading: Boolean = false,
    val error: ErrorResponse? = null,
    val movies: List<ShowModel> = emptyList()
)

class HomeViewModel @Inject constructor(
    private val movieRepository: IMovieRepository,
    private val tvRepository: ITvRepository,
): ViewModel() {

    private val flow = MutableStateFlow(HomePageState())
    val stateFlow = flow.asStateFlow()

    init {
        updateList(1)
    }

    private suspend fun setNewState(
        isLoading: Boolean = true,
        movies: List<ShowModel> = emptyList(),
        error: ErrorResponse? = null
    ) {
        val newState = HomePageState(
            isLoading = isLoading,
            movies = movies,
            error = error
        )
        flow.emit(newState)
    }

    fun updateList(currentPage: Int) {
        viewModelScope.launch(IO) {
            setNewState(isLoading = true)
            val tvs = tvRepository.getPopularTv(currentPage)
            val movies = movieRepository.getPopularMovies(currentPage)

            if(tvs.isEmpty() && movies.isEmpty()){
                setNewState(isLoading = false, error = ErrorResponse())
            }else{
                setNewState(
                    isLoading = false,
                    movies = movies + tvs
                )
            }
        }
    }
}