package com.sergeenko.themoviedatabase.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergeenko.domain.models.ErrorResponse
import com.sergeenko.domain.models.MediaType
import com.sergeenko.domain.models.Response
import com.sergeenko.domain.models.ShowModel
import com.sergeenko.domain.search.ISearchRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SearchScreenState(
    val isLoading: Boolean = false,
    val error: ErrorResponse? = null,
    val movies: List<ShowModel> = emptyList(),
    val tvs: List<ShowModel> = emptyList()
)

class SearchViewModel @Inject constructor(
    private val searchRepository: ISearchRepository,
): ViewModel() {

    private val searchListFlow = MutableStateFlow(SearchScreenState())

    private val searchFlow = MutableStateFlow("")

    fun onSearchResult(): Flow<SearchScreenState> = searchListFlow

    init {
        viewModelScope.launch(IO) {
            searchFlow
                .debounce(500)
                .distinctUntilChanged()
                .collect { answer ->
                    if(answer.isEmpty()){
                        return@collect
                    }
                    val movies = searchRepository.findMoviesByName(answer)
                    val tvs = searchRepository.findTvsByName(answer)

                    setNewState(
                        isLoading = false,
                        movies = movies,
                        tvs = tvs,
                    )
                }
        }
    }

    private suspend fun setNewState(
        isLoading: Boolean = false,
        movies: List<ShowModel> = emptyList(),
        tvs: List<ShowModel> = emptyList(),
        error: ErrorResponse? = null
    ) {
        val newState = SearchScreenState(
            isLoading = isLoading,
            movies = movies,
            tvs = tvs,
            error = error
        )
        searchListFlow.emit(newState)
    }

    fun searchShow(name: String){
        if(name.isNotEmpty()){
            viewModelScope.launch(IO) {
                setNewState(isLoading = true)
                searchFlow.emit(name)
            }
        }
    }
}