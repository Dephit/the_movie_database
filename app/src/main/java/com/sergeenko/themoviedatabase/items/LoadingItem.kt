package com.sergeenko.themoviedatabase.items

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.sergeenko.themoviedatabase.R
import com.sergeenko.themoviedatabase.databinding.LoadingItemBinding
import com.sergeenko.themoviedatabase.databinding.SearchShowItemBinding

class LoadingItem : AbstractBindingItem<LoadingItemBinding>() {

    override val type: Int
        get() = R.id.loadingItemId

    override fun bindView(binding: LoadingItemBinding, payloads: List<Any>) {

    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): LoadingItemBinding {
        return LoadingItemBinding.inflate(inflater, parent, false)
    }
}

