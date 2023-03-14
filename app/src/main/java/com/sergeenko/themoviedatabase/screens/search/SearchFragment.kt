package com.sergeenko.themoviedatabase.screens.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.sergeenko.themoviedatabase.App
import com.sergeenko.themoviedatabase.R
import com.sergeenko.themoviedatabase.databinding.FragmentSearchPageBinding
import com.sergeenko.themoviedatabase.items.*
import com.sergeenko.themoviedatabase.screens.detailed_screen.DetailedFragment
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class SearchFragment: Fragment() {

    @Inject
    lateinit var viewModel: SearchViewModel

    private val binding by lazy {
        FragmentSearchPageBinding.inflate(layoutInflater)
    }

    private val movieAdapter = ItemAdapter<IItem<*>>()
    private val tvAdapter = ItemAdapter<IItem<*>>()
    private val loadingAdapter = ItemAdapter<IItem<*>>()
    private val fastAdapter = FastAdapter.with(listOf(loadingAdapter, movieAdapter, tvAdapter))

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
        initRecyclerView()
        observe()
        initSearchField()
    }

    private fun initSearchField() {
        binding.searchField.editText?.addTextChangedListener {
            viewModel.searchShow(it.toString())
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, VERTICAL, false)
            adapter = fastAdapter
        }

        fastAdapter.onClickListener = { v, adapter, item, position ->
            when(item){
                is SearchShowItem -> {
                    findNavController().navigate(
                        R.id.action_global_detailedFragment,
                        bundleOf(DetailedFragment.ITEM_TAG to item.item)
                    )
                }
                is ErrorItem -> {
                    viewModel.searchShow(binding.searchField.editText?.text.toString())
                }
            }
            true
        }
    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            viewModel.onSearchResult()
                .collectLatest{
                    addNewItems(it)
                }
        }
    }

    private fun addNewItems(state: SearchScreenState) {
        movieAdapter.clear()
        tvAdapter.clear()
        when {
            state.isLoading -> {
                loadingAdapter.setNewList(
                    List(12){
                        EmptySearchShowItem()
                    }
                )
            }
            state.error != null -> {
                loadingAdapter.setNewList(
                    listOf(
                        ErrorItem(state.error.message)
                    )
                )
            }
            else -> {
                loadingAdapter.clear()
                if(state.movies.isNotEmpty()) {
                    val list = mutableListOf<IItem<*>>(TitleItem(getString(R.string.movies)))
                    list.addAll(state.movies.map(::SearchShowItem))
                    movieAdapter.setNewList(list)
                }
                if(state.tvs.isNotEmpty()) {
                    val list = mutableListOf<IItem<*>>(TitleItem(getString(R.string.tvs)))
                    list.addAll(state.tvs.map(::SearchShowItem))
                    tvAdapter.setNewList(list)

                }
            }
        }
    }
}

