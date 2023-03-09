package com.sergeenko.themoviedatabase.items

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.sergeenko.themoviedatabase.R
import com.sergeenko.themoviedatabase.databinding.ErrorItemBinding

class RefreshItem : AbstractBindingItem<ErrorItemBinding>() {

    override val type: Int
        get() = R.id.refreshItemId

    override fun bindView(binding: ErrorItemBinding, payloads: List<Any>) {
        binding.titleText.text = binding.root.context.getString(R.string.click_to_refresh)
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ErrorItemBinding {
        return ErrorItemBinding.inflate(inflater, parent, false)
    }
}