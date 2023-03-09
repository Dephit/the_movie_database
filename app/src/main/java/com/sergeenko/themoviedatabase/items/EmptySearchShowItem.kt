package com.sergeenko.themoviedatabase.items

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.sergeenko.themoviedatabase.R
import com.sergeenko.themoviedatabase.databinding.SearchShowItemBinding
import com.sergeenko.themoviedatabase.databinding.ShowItemBinding
import com.sergeenko.themoviedatabase.utils.ShimmerDrawable

class EmptySearchShowItem : AbstractBindingItem<SearchShowItemBinding>() {

    override val type: Int
        get() = R.id.emptyShowItemId

    override fun bindView(binding: SearchShowItemBinding, payloads: List<Any>) {
        binding.poster.setImageDrawable(ShimmerDrawable.shimmerDrawable)
        binding.name.setBackgroundDrawable(ShimmerDrawable.shimmerDrawable)
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): SearchShowItemBinding {
        return SearchShowItemBinding.inflate(inflater, parent, false)
    }
}