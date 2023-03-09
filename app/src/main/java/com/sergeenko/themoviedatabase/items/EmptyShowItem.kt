package com.sergeenko.themoviedatabase.items

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.sergeenko.themoviedatabase.R
import com.sergeenko.themoviedatabase.databinding.ShowItemBinding
import com.sergeenko.themoviedatabase.utils.ShimmerDrawable

class EmptyShowItem : AbstractBindingItem<ShowItemBinding>() {

    override val type: Int
        get() = R.id.emptyShowItemId

    override fun bindView(binding: ShowItemBinding, payloads: List<Any>) {
        binding.poster.setImageDrawable(ShimmerDrawable.shimmerDrawable)
        binding.name.text = ""
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ShowItemBinding {
        return ShowItemBinding.inflate(inflater, parent, false)
    }
}

