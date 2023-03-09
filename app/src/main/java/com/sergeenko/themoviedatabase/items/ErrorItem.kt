package com.sergeenko.themoviedatabase.items

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mikepenz.fastadapter.binding.AbstractBindingItem
import com.sergeenko.themoviedatabase.R
import com.sergeenko.themoviedatabase.databinding.ErrorItemBinding

class ErrorItem(val errorMessage: String) : AbstractBindingItem<ErrorItemBinding>() {

    override val type: Int
        get() = R.id.errorItemId

    override fun bindView(binding: ErrorItemBinding, payloads: List<Any>) {
        binding.titleText.text = errorMessage
    }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup?): ErrorItemBinding {
        return ErrorItemBinding.inflate(inflater, parent, false)
    }
}

