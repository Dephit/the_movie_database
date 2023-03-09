package com.sergeenko.themoviedatabase.screens.detailed_screen

import androidx.lifecycle.viewModelScope
import com.sergeenko.domain.models.*
import com.sergeenko.domain.movie.IMovieRepository
import com.sergeenko.domain.tv.ITvRepository
import com.sergeenko.themoviedatabase.base.viewModel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DetailedScreenState(
    var isLoading: Boolean = false,
    val movie: DetailedMovieModel? = null,
    val actors: List<People> = emptyList()
)

class DetailedViewModel @Inject constructor(
    private val movieRepository: IMovieRepository,
    private val tvRepository: ITvRepository,
): BaseViewModel<DetailedScreenState>() {

    override val screenStateFlow = MutableStateFlow(DetailedScreenState())

    private suspend fun setNewState(
        isLoading: Boolean = false,
        movie: DetailedMovieModel? = null,
        actors: List<People> = emptyList()
    ) {
        val newState = DetailedScreenState(
            isLoading, movie, actors
        )
        screenStateFlow.emit(newState)
    }


    fun getGenre(show: ShowModel){
        viewModelScope.launch {
            setNewState(isLoading = true)

            val genres: Response = when(show.mediaType){
                MediaType.TV -> tvRepository.getTvById(show.id)
                MediaType.Movie -> movieRepository.getMovieById(show.id)
                MediaType.Person -> TODO()
                MediaType.Unknown -> TODO()
            }
            when(genres){
                is Response.ResponseError -> setNewState(false, show.toDetailedMovie())
                is Response.ResponseSuccess<*> -> {
                    setNewState(false, genres.result as DetailedMovieModel?)
                }
            }
        }
    }

}