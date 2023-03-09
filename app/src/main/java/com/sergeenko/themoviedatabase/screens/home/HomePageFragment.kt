package com.sergeenko.themoviedatabase.screens.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.scroll.EndlessRecyclerOnScrollListener
import com.sergeenko.themoviedatabase.App
import com.sergeenko.themoviedatabase.R
import com.sergeenko.themoviedatabase.databinding.FragmentHomePageBinding
import com.sergeenko.themoviedatabase.items.EmptyShowItem
import com.sergeenko.themoviedatabase.items.ErrorItem
import com.sergeenko.themoviedatabase.items.RefreshItem
import com.sergeenko.themoviedatabase.items.ShowItem
import com.sergeenko.themoviedatabase.screens.detailed_screen.DetailedFragment
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomePageFragment: Fragment() {

    @Inject lateinit var viewModel: HomeViewModel

    private val binding by lazy {
        FragmentHomePageBinding.inflate(layoutInflater)
    }

    private val itemAdapter = ItemAdapter<IItem<*>>()
    private val loadingAdapter = ItemAdapter<IItem<*>>()
    private val fastAdapter = FastAdapter.with(listOf(itemAdapter, loadingAdapter))
    private val gridLayoutManager = GridLayoutManager(context, 3)

    private val endlessRecyclerOnScrollListener = object : EndlessRecyclerOnScrollListener() {
        override fun onLoadMore(currentPage: Int) {
            viewModel.updateList(currentPage + 1)
        }
    }

    override fun onAttach(context: Context) {
        (requireContext().applicationContext as App).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observe()

        binding.refreshText.setOnClickListener {
            val newPage = endlessRecyclerOnScrollListener.currentPage + 1
            viewModel.updateList(newPage)
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = gridLayoutManager
            adapter = fastAdapter
            addOnScrollListener(endlessRecyclerOnScrollListener)

            fastAdapter.onClickListener = { _, _, item, _ ->
                when(item){
                   is ShowItem -> {
                       findNavController().navigate(
                           R.id.action_global_detailedFragment,
                           bundleOf(DetailedFragment.ITEM_TAG to item.item)
                       )
                   }
                }
                true
            }

        }
    }

    private fun observe() {
        lifecycleScope.launch {
            viewModel.stateFlow
                .collect(::addNewItems)
        }
    }

    private fun addNewItems(state: HomePageState) {
        binding.refreshText.isVisible = false
        loadingAdapter.clear()
        when {
            state.isLoading -> {
                loadingAdapter.setNewList(
                    List(12){
                        EmptyShowItem()
                    }
                )
            }
            state.error != null -> {
                binding.refreshText.isVisible = true
            }
            else -> {
                loadingAdapter.clear()
                itemAdapter.add(state.movies.map(::ShowItem))
            }
        }
    }
}



