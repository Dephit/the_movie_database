package com.sergeenko.themoviedatabase.items

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.sergeenko.domain.models.ShowModel
import com.sergeenko.themoviedatabase.R
import com.sergeenko.themoviedatabase.databinding.SearchShowItemBinding
import com.sergeenko.themoviedatabase.utils.ShimmerDrawable

class SearchShowItem(val item: ShowModel) : AbstractBindingItem<SearchShowItemBinding>() {

    override val type: Int
        get() = R.id.showItemId

    override fun bindView(binding: SearchShowItemBinding, payloads: List<Any>) {
        binding.poster.load(item.posterPath){
            placeholder(ShimmerDrawable.shimmerDrawable)
            error(ShimmerDrawable.shimmerDrawable)
            crossfade(true)
        }
        binding.name.text = item.title
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): SearchShowItemBinding {
        return SearchShowItemBinding.inflate(inflater, parent, false)
    }
}

