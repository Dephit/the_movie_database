package com.sergeenko.themoviedatabase.items

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.sergeenko.themoviedatabase.R
import com.sergeenko.themoviedatabase.databinding.ErrorItemBinding
import com.sergeenko.themoviedatabase.databinding.TitleItemBinding


class TitleItem(private val title: String) : AbstractBindingItem<TitleItemBinding>() {

    override val type: Int
        get() = R.id.titleItemId

    override fun bindView(binding: TitleItemBinding, payloads: List<Any>) {
        binding.titleText.text = title
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): TitleItemBinding {
        return TitleItemBinding.inflate(inflater, parent, false)
    }
}
