package com.sergeenko.themoviedatabase.items

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.sergeenko.domain.models.ShowModel
import com.sergeenko.themoviedatabase.R
import com.sergeenko.themoviedatabase.databinding.ShowItemBinding
import com.sergeenko.themoviedatabase.utils.ShimmerDrawable

class ShowItem(val item: ShowModel) : AbstractBindingItem<ShowItemBinding>() {

    override val type: Int
        get() = R.id.showItemId

    override fun bindView(binding: ShowItemBinding, payloads: List<Any>) {
        binding.poster.load(item.posterPath){
            placeholder(ShimmerDrawable.shimmerDrawable)
            error(ShimmerDrawable.shimmerDrawable)
            crossfade(true)
        }
        binding.name.text = item.title
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ShowItemBinding {
        return ShowItemBinding.inflate(inflater, parent, false)
    }
}

