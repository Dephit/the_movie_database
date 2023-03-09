package com.sergeenko.themoviedatabase.screens.detailed_screen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.sergeenko.domain.models.DetailedMovieModel
import com.sergeenko.domain.models.Genre
import com.sergeenko.domain.models.People
import com.sergeenko.domain.models.ShowModel
import com.sergeenko.themoviedatabase.App
import com.sergeenko.themoviedatabase.R
import com.sergeenko.themoviedatabase.databinding.FragmentDetailedBinding
import com.sergeenko.themoviedatabase.utils.BundleSerializableExtractor
import com.sergeenko.themoviedatabase.utils.ShimmerDrawable
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailedFragment: Fragment() {

    @Inject lateinit var viewModel: DetailedViewModel

    private val binding by lazy {
        FragmentDetailedBinding.inflate(layoutInflater)
    }

    override fun onAttach(context: Context) {
        (requireContext().applicationContext as App).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        BundleSerializableExtractor
            .extractValue<ShowModel>(arguments, ITEM_TAG)
            ?.apply(viewModel::getGenre)
        observe()
    }

    private fun observe() {
        lifecycleScope.launch{
            viewModel.screenStateFlow.collect{ screenState ->
                if(screenState.isLoading){
                    binding.poster.setImageDrawable(ShimmerDrawable.shimmerDrawable)
                    return@collect
                }
                if(screenState.movie != null){
                    initShow(
                        item = screenState.movie
                    )
                    initGenres(screenState.movie.genres)
                    initActors(screenState.actors)
                }
            }
        }
    }

    private fun initActors(actors: List<People>) {

    }

    private fun initGenres(genres: List<Genre>) {
        if (genres.isNotEmpty()){
            val genreTitle = getString(R.string.genre_title)
            val genresString = buildString {
                append(genreTitle)
                append("\n" )
                genres.forEachIndexed{ index, it ->
                    append(it.name)
                    if(index != genres.size - 1){
                        append(", ")
                    }
                }
            }
            binding.genres.text = genresString
        }
    }


    private fun initShow(item: DetailedMovieModel?) {
        binding.poster.load(item?.posterPath){
            placeholder(ShimmerDrawable.shimmerDrawable)
            error(ShimmerDrawable.shimmerDrawable)
            crossfade(true)
        }
        binding.name.text = item?.title
        binding.description.text = item?.overview

        binding.length.text = getString(R.string.length, item?.runtime)
        binding.year.text = getString(R.string.release_date, item?.releaseDate)

    }

    companion object{
        const val ITEM_TAG = "ITEM_TAG"
    }

}



